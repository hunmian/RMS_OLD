/**
*Copyright(c)2012 重邮信管工作室
*All right reserved.
*/
package com.cqupt.mis.rms.action.teacher.modify;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.util.ServletContextAware;

import com.cqupt.mis.rms.manager.ResearchInfoDao;
import com.cqupt.mis.rms.model.Proofs;
import com.cqupt.mis.rms.model.TeachingMaterialEditorNew;
import com.cqupt.mis.rms.model.TeachingMaterialSetNew;
import com.cqupt.mis.rms.service.ResearchInfoService;
import com.cqupt.mis.rms.utils.Confirm;
import com.cqupt.mis.rms.utils.GenerateUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
*<p>Title:处理教师用户提交教材出版信息的Action</p>
*<p>Description:接收用户提交的信息并处理</p>
*@author LvHai
*@version 1.0
**/
@SuppressWarnings("serial")
public class ModifyTeachingMaterialSetNewAction extends ActionSupport implements ServletContextAware {
	//注入接口
	private ResearchInfoService researchInfoService;
	private ResearchInfoDao researchInfoDao;
	
	private String teachingMaterialId;
	private String setClass;
	private String setTime;
	private String numberProject;
	private String teachingMaterialName;
	private String resultsPostedStatus;
	private String wordsNumbers;
	private String collegeAward;
	private String remarks;
	

	private String submit;

	
	//成员信息
	private String[] memberName;
	private String[] remarksMem;
	
	//上传文件
	private File[] upload;// 实际上传文件
	private String[] uploadContentType; // 文件的内容类型
	private String[] uploadFileName; // 上传文件名
	private String[] descProof;//旁证材料描述
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String execute() throws Exception {
		
		//如果submit==保存，status=0，如果submit==提交，status=1
		int status;
		if("保存".equals(submit)){
			status = 0;
		}else if("提交".equals(submit)){
			status = 1;
		}else{
			status = -1;
		}
		
		List<Proofs> proofs = new ArrayList<Proofs>();
		List<TeachingMaterialEditorNew> teachingMaterialEditors = new ArrayList<TeachingMaterialEditorNew>();
		String targetDirectory = servletContext.getRealPath(GenerateUtils.generateSavePath());//获得路径
		TeachingMaterialSetNew teachingMaterialSet = (TeachingMaterialSetNew)researchInfoDao.findResearchInfoByIdAndModelNameAndFactor(teachingMaterialId, "TeachingMaterialSetNew", "teachingMaterialId");
		teachingMaterialSet.setNumberProject(numberProject);
		teachingMaterialSet.setResultsPostedStatus(resultsPostedStatus);
		teachingMaterialSet.setSetClass(setClass);
		teachingMaterialSet.setSetTime(setTime);
		if(""!=wordsNumbers)
		{
			teachingMaterialSet.setWordsNumbers(Float.parseFloat(wordsNumbers));
			
		}
		if(""!=collegeAward)
		{
			teachingMaterialSet.setCollegeAward(Float.parseFloat(collegeAward));

		}
		teachingMaterialSet.setRemarks(remarks);
		teachingMaterialSet.setTeachingMaterialId(teachingMaterialId);
		teachingMaterialSet.setTeachingMaterialName(teachingMaterialName);
		teachingMaterialSet.setStatus(status);
		
		try {
			//上传旁证材料
			if(upload != null){
				for (int i = 0; i < upload.length; i++){
					String fileName = uploadFileName[i];// 上传的文件名
					String fileType = uploadContentType[i];// 文件类型
					String targetFileName = GenerateUtils.generateFileName(fileName);   
			        File target = new File(targetDirectory, targetFileName);
			        FileUtils.copyFile(upload[i], target);
			        Proofs proof = new Proofs();
			        proof.setInfoApprovedId(teachingMaterialId);
			        proof.setTimeProofUpload(new Date());
			        proof.setUploadProofName(fileName);
			        proof.setUploadContentType(fileType);
			        proof.setUploadRealName(targetFileName);
			        proof.setProofPath(GenerateUtils.generateSavePath());
			        if(!"".equals(descProof[i]) && descProof[i] != null){
			        	proof.setDescProof(descProof[i]);
			        }
			        proofs.add(proof);
				}
			}
			
			//保存成员信息
			if(memberName != null){
				for(int j = 0; j < memberName.length; j++){
					if(!"".equals(memberName[j]) && memberName[j] != null){
						TeachingMaterialEditorNew teachingMaterialEditor = new TeachingMaterialEditorNew();
						teachingMaterialEditor.setTeachingMaterialSetNew(teachingMaterialSet);
						teachingMaterialEditor.setEditorName(memberName[j]);
						if(!"".equals(remarksMem[j]) && remarksMem[j] != null){
							teachingMaterialEditor.setRemarks(remarksMem[j]);
						}
						teachingMaterialEditors.add(teachingMaterialEditor);
					}
				}
			}
			
			boolean result1 = researchInfoService.modifyResearchInfo(teachingMaterialSet);
			boolean result2 = researchInfoService.modifyProofs(proofs);
			boolean result3 = researchInfoService.modifyResearchMemberInfo(teachingMaterialId, "TeachingMaterialEditorNew", "teachingMaterialSetNew", "teachingMaterialId", 24, teachingMaterialEditors);
			Confirm confirm = new Confirm();
			if(result1 && result2 && result3){
				confirm.setIsSuccess("right");
				confirm.setMessage("教材出版信息修改成功");
				confirm.setUrl("viewTeachingMaterialSetNew.action");
				confirm.setRetName("个人教材出版信息页面");
			}else{
				confirm.setIsSuccess("error");
				confirm.setMessage("教材出版信息修改失败");
				confirm.setUrl("viewTeachingMaterialSetNew.action");
				confirm.setRetName("个人教材出版信息页面");
			}
			ActionContext.getContext().put("confirm", confirm);
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
	}

	public void setResearchInfoService(ResearchInfoService researchInfoService) {
		this.researchInfoService = researchInfoService;
	}

	public void setResearchInfoDao(ResearchInfoDao researchInfoDao) {
		this.researchInfoDao = researchInfoDao;
	}

	public void setTeachingMaterialId(String teachingMaterialId) {
		this.teachingMaterialId = teachingMaterialId;
	}

	public void setSetClass(String setClass) {
		this.setClass = setClass;
	}

	public void setSetTime(String setTime) {
		this.setTime = setTime;
	}

	public void setNumberProject(String numberProject) {
		this.numberProject = numberProject;
	}

	public void setTeachingMaterialName(String teachingMaterialName) {
		this.teachingMaterialName = teachingMaterialName;
	}

	public void setResultsPostedStatus(String resultsPostedStatus) {
		this.resultsPostedStatus = resultsPostedStatus;
	}

	public void setSubmit(String submit) {
		this.submit = submit;
	}

	public void setUpload(File[] upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setDescProof(String[] descProof) {
		this.descProof = descProof;
	}

	public void setMemberName(String[] memberName) {
		this.memberName = memberName;
	}

	public void setRemarksMem(String[] remarksMem) {
		this.remarksMem = remarksMem;
	}

	public String getWordsNumbers() {
		return wordsNumbers;
	}

	public void setWordsNumbers(String wordsNumbers) {
		this.wordsNumbers = wordsNumbers;
	}

	public String getCollegeAward() {
		return collegeAward;
	}

	public void setCollegeAward(String collegeAward) {
		this.collegeAward = collegeAward;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
