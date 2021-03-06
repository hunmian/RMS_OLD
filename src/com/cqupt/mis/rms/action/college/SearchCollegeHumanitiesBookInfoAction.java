package com.cqupt.mis.rms.action.college;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.HumanitiesBook;
import com.cqupt.mis.rms.model.HumanitiesBookAuthor;
import com.cqupt.mis.rms.service.HumanitiesBookInfoService;
import com.cqupt.mis.rms.service.SearchCQUPTUserService;
import com.cqupt.mis.rms.service.model.ModelInfo;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class SearchCollegeHumanitiesBookInfoAction extends ActionSupport{
	private SearchCQUPTUserService searchCQUPTUserService;
	private HumanitiesBookInfoService humanitiesBookInfoService;
	private List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos;
	
	private String roleId;
	
	private String stringName1;
	private String stringValue1;
	
	private String stringName2;
	private String stringValue2;
	
	private String stringName3;
	private String stringValue3;
	
	private String stringName4;
	private String stringValue4;
	
	private String floatName1;
	private float minFloatValue1;
	private float maxFloatValue1;
	
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
	public void getAllHumanitiesBookInfo(){
		roleId = ActionContext.getContext().getSession().get("roleId").toString();
		int role = java.lang.Integer.parseInt(roleId);
		List<CQUPTUser> cquptUsers = searchCQUPTUserService.findManageUserByRoleId(role);
		this.humanitiesBookInfos = humanitiesBookInfoService.findAllHumanitiesBookInfo(cquptUsers);
	}
	
	public String execute(){
		this.getAllHumanitiesBookInfo();
		humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByStringFactor(humanitiesBookInfos, "status", "2");
		if(stringName1==null||stringName1.equals("请选择")){
		}else{
			if(stringValue1==null||stringValue1.equals("")){
			}else{
				humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByStringFactor(humanitiesBookInfos, stringName1, stringValue1);
			}
		}
		if(stringName2==null||stringName2.equals("请选择")){
		}else{
			if(stringValue2==null||stringValue2.equals("")){
			}else{
				humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByStringFactor(humanitiesBookInfos, stringName2, stringValue2);
			}
		}
		if(stringName3==null||stringName3.equals("请选择")){
		}else{
			if(stringValue3==null||stringValue3.equals("")){
			}else{
				humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByStringFactor(humanitiesBookInfos, stringName3, stringValue3);
			}
		}
		if(stringName4==null||stringName4.equals("请选择")){
		}else{
			if(stringValue4==null||stringValue4.equals("")){
			}else{
				humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByStringFactor(humanitiesBookInfos, stringName4, stringValue4);
			}
		}
		
		if(floatName1==null||floatName1.equals("请选择")){
		}else{
			if(minFloatValue1==0&&maxFloatValue1==0){
			}else{
				humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByNumFactor(humanitiesBookInfos, floatName1, minFloatValue1, maxFloatValue1);
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
			humanitiesBookInfos = humanitiesBookInfoService.searchHumanitiesBookInfoByDateFactor(humanitiesBookInfos, dateName, beginTime, endTime);
		}
		ActionContext.getContext().put("humanitiesBookInfos", humanitiesBookInfos);
	
		type="search";

		if(stringName1!=null){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(int i=0;i<humanitiesBookInfos.size();i++){
			builder.append(humanitiesBookInfos.get(i).getModel().getBookId())
			.append(":{bookId:\"").append(humanitiesBookInfos.get(i).getModel().getBookId())
			.append("\",bookName:\"").append(humanitiesBookInfos.get(i).getModel().getBookName())
			.append("\",grades:\"").append(humanitiesBookInfos.get(i).getModel().getGrades())
			.append("\",publisher:\"").append(humanitiesBookInfos.get(i).getModel().getPublisher())
			.append("\",publishedTime:\"").append(humanitiesBookInfos.get(i).getModel().getPublishedTime())
			.append("\",ISBN:\"").append(humanitiesBookInfos.get(i).getModel().getISBN())
			.append("\",wordcount:\"").append(humanitiesBookInfos.get(i).getModel().getWordcount())
			.append("\",belongProject:\"").append(humanitiesBookInfos.get(i).getModel().getBelongProject())
			.append("\",subjectsClassify:\"").append(humanitiesBookInfos.get(i).getModel().getSubjectsClassify())
			.append("\",submitUser:\"").append(humanitiesBookInfos.get(i).getModel().getSubmitUser().getUserName())
			.append("\",approvedUser:\"").append(humanitiesBookInfos.get(i).getModel().getApprovedUser().getUserName())
			.append("\",status:\"").append(humanitiesBookInfos.get(i).getModel().getStatus())
			.append("\"}");
			if(i+1<humanitiesBookInfos.size()){
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

	public void setHumanitiesBookInfoService(
			HumanitiesBookInfoService humanitiesBookInfoService) {
		this.humanitiesBookInfoService = humanitiesBookInfoService;
	}

	public void setHumanitiesBookInfos(
			List<ModelInfo<HumanitiesBook, HumanitiesBookAuthor>> humanitiesBookInfos) {
		this.humanitiesBookInfos = humanitiesBookInfos;
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

	public void setFloatName1(String floatName1) {
		this.floatName1 = floatName1;
	}

	public void setMinFloatValue1(float minFloatValue1) {
		this.minFloatValue1 = minFloatValue1;
	}

	public void setMaxFloatValue1(float maxFloatValue1) {
		this.maxFloatValue1 = maxFloatValue1;
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
