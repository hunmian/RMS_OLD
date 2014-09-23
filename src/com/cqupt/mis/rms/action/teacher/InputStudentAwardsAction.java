package com.cqupt.mis.rms.action.teacher;

import java.util.List;

import com.cqupt.mis.rms.manager.SearchDao;
import com.cqupt.mis.rms.service.DynamicDataFieldService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户输入学生获奖信息之前的Action</p>
*<p>Description:接收输入请求，取出动态的数据库字段，返回后展示在输入页面</p>
*@author Bern
*@version 2.0
**/
public class InputStudentAwardsAction extends ActionSupport {
	//注入服务层接口
	private DynamicDataFieldService dynamicDataFieldService;
	private SearchDao searchDao;
	
	public String execute() {
		List<Object> fields = searchDao.SearchObjectsByFactor("com.cqupt.mis.rms.model.StudentAwardsField", "isDelete", 0);		
		ActionContext.getContext().put("allFields", fields);
		return SUCCESS;
	}

	public DynamicDataFieldService getDynamicDataFieldService() {
		return dynamicDataFieldService;
	}

	public void setDynamicDataFieldService(
			DynamicDataFieldService dynamicDataFieldService) {
		this.dynamicDataFieldService = dynamicDataFieldService;
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}

}