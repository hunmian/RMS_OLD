<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>录入指导学生参赛获奖信息</title>
    <link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
    <script src="js/addPerson.js" type="text/javascript"></script>
    <script src="js/vanadium.js" type="text/javascript"></script>
	<script src="js/check.js" type="text/javascript"></script>
	<link href="css/input.css" rel="stylesheet" type="text/css" />
	<link href="css/upload.css" rel="stylesheet" type="text/css" />
	<script src="js/teacher/inputInfo.js" type="text/javascript"></script>
	<script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
</head>
<body style="padding:0px;">
	<form id="form" name="form" action="submitStudentAwardsRecord.action" onsubmit="return checkClickAndSubmit();" method="post" enctype="multipart/form-data">
	
	<!-- 提示信息 -->
	<b>提示：对应栏没有信息的请填写“无”！</b>“赛事”包括教务处、学生处、团委统一组织申报的各项比赛；“获奖级别”包括国家级、省部级1、2、3等奖。
	
	<div id="allpage">
	<div class="item">
		<div class="title">
			录入指导学生参赛获奖信息
			<div class="clear"></div>
		</div>
		<div class="content">
			<div class="line">	<!-- ####三个换行#### -->
				<div class="element" style="height:31px;">
					<label for="awardsName">赛事名称</label>
					<input type="text" id="awardsName" name="awardsName" class=":required" />
				</div>
				<s:iterator value="#allFields" id="f">
				<div class="element" style="height:31px;">
					<label for="<s:property value="#f.name"/>"><s:property value="#f.description"/></label>
					<input type="text" id="<s:property value="#f.name"/>" name="<s:property value="#f.name"/>" class=":required" />
				</div>
				</s:iterator>
			</div>
			
			<div class="clear" style="height:15px;"></div>
			<div class="title">
			指导教师信息
			</div>
			<div id="membertoolbar"></div>
			<div class="line spe">
				<div class="element del person">
					<label for="memberName">指导教师姓名:</label>
					<input type="text" id="memberName" name="memberName" />
				</div>
				<div class="element del detail">
					<label for="remarksMem">备注:</label>
					<input type="text" id="remarksMem" name="remarksMem" />
				</div>
				<div class="element del">
					<input type="button" style="width:50px;" name="Par" class="delPerson" value="删除" />
				</div>
			</div>
			
			<div id="hippo" style="margin:0; padding:0">
			<div class="clear" style="height:15px;"></div>
    			<div class="title">
    			上传旁证材料
    			</div>
    			<div id="newproofstoolbar"></div>
    			<div class="clear" style="height:15px;"></div>
				<div class="disc common">
					<div class="left text">
						<input type="file" class="file" name="upload" value="浏览" />
					</div>
					<div class="left btn">
						<input type="button" style="width:50px;" name="Par" class="delPerson" value="删除" />
					</div>
					<div class="left">
						<label for="descProof">材料描述：</label>
						<input type="text" id="descProof" name="descProof" />
					</div>
					<div class="clear"></div>
				</div>
			</div>
			
		</div>
		
	</div>
	
	<p id="tijiao">
		<input type="submit" id="submit" name="submit" onclick="checkResult('save');" class="btn" value="保存" />
		<input type="submit" id="submit" name="submit" onclick="checkResult('confirm');" class="btn" value="提交" />
		<input type="reset" class="btn" value="重置" />
	</p>
	</div>
	</form>
	
</body>
</html>