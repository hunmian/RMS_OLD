<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
    
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
        <title>创新创业训练计划项目信息</title>
   
    
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.3.2.min.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/core/base.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerGrid.js" type="text/javascript"></script> 
    <script src="lib/ligerUI/js/plugins/ligerTextBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerCheckBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenu.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerComboBox.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerMenuBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerToolBar.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerButton.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerResizable.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDialog.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/plugins/ligerDrag.js" type="text/javascript"></script>
     <link rel="stylesheet" type="text/css" href="js/XYTipsWindow/style.css">
	<script type="text/javascript" src="js/XYTipsWindow/jquery.XYTipsWindow.2.8.js"></script>
	<script type="text/javascript" src="js/jquery.clearfield.js"></script>
    <script src="js/collegeaprovel/detail/CollegeProjectDetail.js" type="text/javascript"></script>
</head>
<body style="padding:0px;"> 
<s:iterator value="teachAchievementsCQlists" >
<div id="allpage">

	<div class="item">
		<div class="title">
			1.创新创业训练计划项目信息
		</div>
    	
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="classContribute">负责人:</label>
					<input type="text" id="classAchievements1" name="classAchievements1" value='<s:property value="classAchievements"/>' readonly/>
				</div>
				<div class="element">
					<label for="typeContribute">项目类型:</label>
					<input type="text" id="projectType" name="projectType" value='<s:property value="projectType"/>' readonly/>
				</div>
				<div class="element">
					<label for="courseName">项目名称:</label>
					<input type="text" id="projectName" name="projectName" value='<s:property value="projectName"/>' readonly/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="applicantRanking">项目编号:</label>
					<input type="text" id="reportedAmounts" name="reportedAmounts" value='<s:property value="reportedAmounts"/>' readonly/>
				</div>
				<div class="element">
					<label for="checkTime">立项时间:</label>
					<input type="text" id="timeAchievements" name="timeAchievements" value="${timeAchievements}" readonly/>
				</div>
				<div class="element">
					<label for="endTime">结题时间:</label>
					<input type="text" id="gradeAchievements" name="gradeAchievements" value="${gradeAchievements}" readonly/>
				</div>
				
			</div>
			<div class="line">
				<div class="element">
					<label for="timeContribute">项目来源:</label>
					<input type="text" id="timeContribute" name="timeContribute" value='<s:property value="timeContribute"/>' readonly/>
				</div>
				<div class="element">
					<label for="remarks1">备注:</label>
					<input type="text" id="remarks1" name="remarks1" value='<s:property value="remarks"/>' readonly/>
				</div>
			    <div class="element">
					<label for="collegeAward">奖励金额:</label>
					<input type="text" id="verifyAmounts" name="verifyAmounts" value='<s:property value="verifyAmounts"/>' readonly/>
				</div>
				
			</div>
			
			<div class="line">
			    <div class="element">
					<label for="submitUser">提交该信息的用户:</label>
					<input type="text" id="submitUser" name="submitUser" value='<s:property value="submitUser.userName"/>'/>
				</div>
				<div class="element">
					<label for="status">该信息的状态:</label>
					<s:if test="status==0">
					<input type="text" id="status" name="status" value='已保存' />
					</s:if>
					<s:if test="status==1">
					<input type="text" id="status" name="status" value='未审批' />
					</s:if>
					<s:if test="status==2">
					<input type="text" id="status" name="status" value='已审批通过' />
					</s:if>
					<s:if test="status==3">
					<input type="text" id="status" name="status" value='审批未通过' />
					</s:if>
				</div>
			</div>
		</div>
		
	</div>
	

	
	<div class="clear" style="height:15px;"></div>
	<div class="item">
		<div class="title">
			2.指导老师信息
		</div>
		<s:iterator value="teachAchievementsDeclarantlists" >
		<div class="content">
			<div class="line">
				<div class="element">
					<label for="declarantName">指导老师姓名:</label>
					<input type="text" id="declarantName" name="declarantName" value='<s:property value="declarantName"/>'/>
				</div>
				<div class="element">
					<label for="remarks">备注:</label>
					<input type="text" id="remarks" name="remarks" value='<s:property value="remarks"/>'/>
				</div>
			</div>
		</div>
		</s:iterator>
	</div>
	<div class="clear" style="height:15px;"></div>
    <div class="item">
    	<div class="title">
			3.旁证材料
		</div>
		<div class="content">
    	<div id="maingrid" style="margin:0; padding:0">
     	<s:iterator value="proofslists">
     	<script type="text/javascript">
     		var row = {proofId: "${proofId}", infoApprovedId: "${infoApprovedId}", proofPath: "${proofPath}",
     				uploadProofName: "${uploadProofName}", uploadRealName: "${uploadRealName}", 
     				uploadContentType: "${uploadContentType}", timeProofUpload: "${timeProofUpload}", descProof: "${descProof}"};
			rows.push(row);
     	</script>
     	</s:iterator>
    	</div>
    	</div>
    </div>
    
    <div class="item">
    	<div class="content">
    	<div style="text-align:right; padding:0 30px 20px 30px;">
	    <form action="collegeUpdateStatus.action?id=<s:property value="achievementsId"/>&modelName=TeachAchievementsCQ&idName=achievementsId" onsubmit="return checkPassed();" method="post"> 
		
			<input style="background:url(images/button.png); width:57px; height:25px; border:0; cursor:pointer; color:#fff;" type="submit"  value="审批通过" />
			<input type="hidden" value="2" name="status">
		
	    </form>
	    <form name="form" onsubmit="return checkReturnReason();" action="collegeUpdateStatus.action?id=<s:property value="achievementsId"/>&modelName=TeachAchievementsCQ&idName=achievementsId" method="post"> 
	    	<br/>
		    <p>
		    	拒绝理由：
		  		<input type="text" name="returnReason" id="returnReason" style="margin-right:20px;">
				<input type="submit" style="float:right;background:url(images/button.png); width:57px; height:25px; border:0; cursor:pointer;color:#fff;" value="审批拒绝"/>
				<input type="hidden" style="float:right;" value="3" name="status">
			</p>
	    </form>
	  	</div>
    	</div>
    
    </div>
    </div>
    	</s:iterator>

</body>
</html>                                                                                                                                                                                                                                                                                                                                                                                                                    