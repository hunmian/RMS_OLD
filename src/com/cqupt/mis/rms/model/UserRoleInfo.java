package com.cqupt.mis.rms.model;

/**
 * <p>
 * Title:用户 角色信息表
 * </p>
 * <p>
 * Copyright:Copyright(c)2012
 * </p>
 * <p>
 * Company:重邮信管工作室
 * </p>
 * 
 * @author LM
 * @version 1.0
 * */
@SuppressWarnings("serial")
public class UserRoleInfo implements java.io.Serializable {
	// 用户登录信息
	private UserLogin userLogin;
	// 用户角色信息
	private CQUPTRole roleinfo;

	public UserLogin getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(UserLogin userLogin) {
		this.userLogin = userLogin;
	}

	public CQUPTRole getRoleinfo() {
		return roleinfo;
	}

	public void setRoleinfo(CQUPTRole roleinfo) {
		this.roleinfo = roleinfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((userLogin == null) ? 0 : userLogin.hashCode());
		result = prime * result
				+ ((roleinfo == null) ? 0 : roleinfo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRoleInfo other = (UserRoleInfo) obj;
		if (userLogin == null) {
			if (other.userLogin != null)
				return false;
		} else if (!userLogin.equals(other.userLogin))
			return false;
		if (roleinfo == null) {
			if (other.roleinfo != null)
				return false;
		} else if (!roleinfo.equals(other.roleinfo))
			return false;
		return true;
	}
}
