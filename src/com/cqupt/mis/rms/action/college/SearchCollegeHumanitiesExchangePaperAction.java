package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesExchangePaper;
import com.cqupt.mis.rms.model.HumanitiesExchangePaperAuthor;
import com.cqupt.mis.rms.service.HumanitiesExchangePaperService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeHumanitiesExchangePaperAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private HumanitiesExchangePaperService humanitiesExchangePaperService;
	private List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos;
	
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	
	private String dateName;
	private String begin;
	private String end;
    private String type;
		
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void getAllHumanitiesExchangePaperInfo(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.humanitiesExchangePaperInfos = humanitiesExchangePaperService.findAllHumanitiesExchangePaperInfo(cquptUsers);
	}
	
	public String execute(){
		this.getAllHumanitiesExchangePaperInfo();
		humanitiesExchangePaperInfos = humanitiesExchangePaperService.searchHumanitiesExchangePaperInfoByStringFactor(humanitiesExchangePaperInfos, "status", "2");
		
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				humanitiesExchangePaperInfos = humanitiesExchangePaperService.searchHumanitiesExchangePaperInfoByStringFactor(humanitiesExchangePaperInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				humanitiesExchangePaperInfos = humanitiesExchangePaperService.searchHumanitiesExchangePaperInfoByStringFactor(humanitiesExchangePaperInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				humanitiesExchangePaperInfos = humanitiesExchangePaperService.searchHumanitiesExchangePaperInfoByStringFactor(humanitiesExchangePaperInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				humanitiesExchangePaperInfos = humanitiesExchangePaperService.searchHumanitiesExchangePaperInfoByStringFactor(humanitiesExchangePaperInfos, stringName4, stringValue4);
			}
		}
		
		if(dateName==null||dateName.equals("请选择")){
		}else{
			Date beginTime = new Date();
			Date endTime = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			if(begin==null||begin.equals("")){
				try {
					beginTime = dateFormat.parse("1950-01-01");
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else{
				try {
					beginTime = dateFormat.parse(begin);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if(end==null||end.equals("")){				
			}else{
				try {
					endTime = dateFormat.parse(end);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
			humanitiesExchangePaperInfos = humanitiesExchangePaperService.searchHumanitiesExchangePaperInfoByDateFactor(humanitiesExchangePaperInfos, dateName, beginTime, endTime);
		}
		
		ActionContext.getContext().put("humanitiesExchangePaperInfos", humanitiesExchangePaperInfos);
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<humanitiesExchangePaperInfos.size();i++){
			builder.append(humanitiesExchangePaperInfos.get(i).getModel().getExchangePaperId())
			.append(":{exchangePaperId:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getExchangePaperId())
			.append("\",exchangePaperName:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getExchangePaperName())
			.append("\",searchStation:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getSearchStation())
			.append("\",subjectsClassify:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getSubjectsClassify())
			.append("\",publishedTime:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getPublishedTime())
			.append("\",hostConferenceName:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getHostConferenceName())
			.append("\",submitUser:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getApprovedUser().getUserName())
			.append("\",status:\"").append(humanitiesExchangePaperInfos.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<humanitiesExchangePaperInfos.size()){
				builder.append(",");
			}
		}
		builder.append("}");
		
		try {
			response.getWriter().println(builder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			return null;
		}else{
			return "SUCCESS";
		}
	}

	public void setSearchCQUPTUserService(
			SearchCQUPTUserService searchCQUPTUserService) {
		this.searchCQUPTUserService = searchCQUPTUserService;
	}

	public void setHumanitiesExchangePaperService(
			HumanitiesExchangePaperService humanitiesExchangePaperService) {
		this.humanitiesExchangePaperService = humanitiesExchangePaperService;
	}

	public void setHumanitiesExchangePaperInfos(
			List<ModelInfo<HumanitiesExchangePaper, HumanitiesExchangePaperAuthor>> humanitiesExchangePaperInfos) {
		this.humanitiesExchangePaperInfos = humanitiesExchangePaperInfos;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public void setStringName1(String stringName1) {
		this.stringName1 = stringName1;
	}

	public void setStringValue1(String stringValue1) {
		this.stringValue1 = stringValue1;
	}

	public void setStringName2(String stringName2) {
		this.stringName2 = stringName2;
	}

	public void setStringValue2(String stringValue2) {
		this.stringValue2 = stringValue2;
	}

	public void setStringName3(String stringName3) {
		this.stringName3 = stringName3;
	}

	public void setStringValue3(String stringValue3) {
		this.stringValue3 = stringValue3;
	}

	public void setStringName4(String stringName4) {
		this.stringName4 = stringName4;
	}

	public void setStringValue4(String stringValue4) {
		this.stringValue4 = stringValue4;
	}

	public void setDateName(String dateName) {
		this.dateName = dateName;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
