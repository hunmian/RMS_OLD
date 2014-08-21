package com.cqupt.mis.rms.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cqupt.mis.rms.model.CQUPTRole;
import com.cqupt.mis.rms.service.UserManagerService;


public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private UserManagerService userManagerService;
	private static final String USERNAME = "userName";
	private static final String USERPWD = "userPwd";
	private static final String LOGINTYPE = "loginType";
	
	@Override  
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {  
        if (!request.getMethod().equals("POST")) {  
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());  
        }
        
        String userName = obtainUsername(request);
        String userPwd = obtainPassword(request);
        int loginType = obtainLoginType(request);
        
        CQUPTRole role = userManagerService.checkRoleLevelByUserIdAndRoleLevelId(userName, loginType);
		if(role!= null){
			// 角色和登录类型匹配，判断用户名和密码是否正确
			
			boolean result = userManagerService.checkUNameAndUPass(userName,userPwd);
			if (result) {
			// 用户名和密码正确,则保存登录名和用户角色信息——因为后面很多地方会使用到这两个参数，所以存放在session里面
				request.getSession().setAttribute("userId", userName);
				request.getSession().setAttribute("roleId", role.getRoleId());
			} else {
//				request.setAttribute("LoginError","用户名或密码错误！");
				throw new AuthenticationServiceException("用户名或者密码错误！");
			}
		} else {
//			request.setAttribute("LoginError", "身份不匹配,请重新选择！");
			throw new AuthenticationServiceException("身份不匹配,请重新选择！");
		} 
          
        //UsernamePasswordAuthenticationToken实现 Authentication  
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(userName, userPwd);  
        // Place the last username attempted into HttpSession for views  
          
        // 允许子类设置详细属性  
        setDetails(request, authRequest);  
        
        // 运行UserDetailsService的loadUserByUsername 再次封装Authentication  
        return this.getAuthenticationManager().authenticate(authRequest);  
    }
	
	@Override  
    protected String obtainUsername(HttpServletRequest request) {  
        Object obj = request.getParameter(USERNAME);  
        return null == obj ? "" : obj.toString();  
    }  
  
    @Override  
    protected String obtainPassword(HttpServletRequest request) {  
        Object obj = request.getParameter(USERPWD);  
        return null == obj ? "" : obj.toString();  
    }

    protected int obtainLoginType(HttpServletRequest request) {  
        int obj = Integer.parseInt(request.getParameter(LOGINTYPE));  
        return obj;
    }

	public UserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}

}