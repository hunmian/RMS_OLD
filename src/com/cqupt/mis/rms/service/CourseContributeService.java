package com.cqupt.mis.rms.service;

import java.util.Date;
import java.util.List;

import com.cqupt.mis.rms.model.CQUPTUser;
import com.cqupt.mis.rms.model.CourseContribute;
import com.cqupt.mis.rms.model.CourseContributeMember;
import com.cqupt.mis.rms.service.model.ModelInfo;

public interface CourseContributeService {
	//根据课程建设ID查找指定课程建设信息
	public ModelInfo<CourseContribute, CourseContributeMember> findCourseContributeInfoByCourseId(String courseId);
	//根据用户集合查找与该用户群体相关的课程建设信息。
	public List<ModelInfo<CourseContribute, CourseContributeMember>> findAllCourseContributeInfo(List<CQUPTUser> CQUPTUsers);
	
	//从指定CourseContributeInfo集合中筛检出符合条件的CourseContributeInfo集合
	//筛选字段为字符串类型
	public List<ModelInfo<CourseContribute, CourseContributeMember>> searchCourseContributeInfoByStringFactor(List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos,String factorName,String factorValue);
	//筛选字段为数值类型
	public List<ModelInfo<CourseContribute, CourseContributeMember>> searchCourseContributeInfoByNumFactor(List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos,String factorName,float minNum,float maxNum);
	//筛选字段为时间类型
	public List<ModelInfo<CourseContribute, CourseContributeMember>> searchCourseContributeInfoByDateFactor(List<ModelInfo<CourseContribute, CourseContributeMember>> courseContributeInfos,String factorName,Date begin,Date end);

}
