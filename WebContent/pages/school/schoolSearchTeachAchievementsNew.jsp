<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@page import="java.util.List"%>
<%@page import="com.cqupt.mis.rms.model.*"%>
<%@page import="com.cqupt.mis.rms.service.model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>
<base href="<%=basePath%>"> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html xmlns="http://www.w3.org/1999/xhtml"> -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>发表教改论文查询</title>
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <link href="css/search.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script> 
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
    
    <script src="js/search/SearchTeachAchievementsNew.js" type="text/javascript"></script>
</head>
<body style="padding:0px; "> 

<div class="l-loading" style="display:block" id="pageloading"></div> 
  
 <form id="form1" action="searchSchoolTeachAchievementsNew.action" method="post"> 



<div id="hippo">
	<ul class="list">
		<li class="item">
			<span class="logical">
			</span>
			<span class="logical">学院：</span>
			<select class="logical_item" name="collegeId">
				<option value="all">全部</option>
				<c:if test="${not empty cquptColleges}">
					<c:forEach items="${cquptColleges}" var="cquptCollege">
						<option value="${cquptCollege.collegeId }">${cquptCollege.collegeName }</option>
					</c:forEach>
				</c:if>
			</select>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName1">
				<option>请选择</option>
				<option value="achievementsId">教改论文编号</option>
				<option value="classAchievements">期刊类别</option>
				<option value="projectName">论文名称</option>
				<option value="levelAchievements">期刊名称</option>
				<option value="timeAchievements">出版日期</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue1"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName2">
				<option>请选择</option>
				<option value="achievementsId">教改论文编号</option>
				<option value="classAchievements">期刊类别</option>
				<option value="projectName">论文名称</option>
				<option value="levelAchievements">期刊名称</option>
				<option value="timeAchievements">出版日期</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue2"/>
			<div class="clear"></div>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName3">
				<option>请选择</option>
				<option value="achievementsId">教改论文编号</option>
				<option value="classAchievements">期刊类别</option>
				<option value="projectName">论文名称</option>
				<option value="levelAchievements">期刊名称</option>
				<option value="timeAchievements">出版日期</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue3"/>
			<div class="clear"></div>
			
			<span class="logical">
			</span>
			<select class="logical_item" name="stringName4">
				<option>请选择</option>
				<option value="achievementsId">教改论文编号</option>
				<option value="classAchievements">期刊类别</option>
				<option value="projectName">论文名称</option>
				<option value="levelAchievements">期刊名称</option>
				<option value="timeAchievements">出版日期</option>
				<option value="submitUser">提交者</option>
				<option value="approvedUser">审批者</option>
				<option value="author">作者</option>
			</select>
			<input type="text" class="logical_word"  name="stringValue4"/>
			<div class="clear"></div>
		</li>
		<li class="item">
			<span class="logical">
			</span>
			<select class="logical_item" name="floatName1">
				<option>请选择</option>
				<option value="collegeAward">学院奖励</option>
			</select>
			<input type="text" class="logical_word"  name="minFloatValue1"/>
			<div class="clear"></div>
			<input type="text" class="logical_word"  name="maxFloatValue1"/>
			<div class="clear"></div>
		</li>
	</ul>
</div>
	<p id="tijiao" style="margin:1em 0 1em 20em;">
		<input type="submit" class="btn" value="查询" />
		<input type="reset" class="btn" value="重置" />
	</p>
	
	<div id="toptoolbar"></div>
    <div id="maingrid" style="margin:0; padding:0">
     
    
   <c:if test="${not empty teachAchievementsNewInfos}">
     	 <c:forEach items="${teachAchievementsNewInfos}" var="teachAchievementsInfo">
     	 	<script type="text/javascript">
     	 	var row = {achievementsId: "${teachAchievementsInfo.model.achievementsId}", 
					   classAchievements: "${teachAchievementsInfo.model.classAchievements}", 
					   projectName: "${teachAchievementsInfo.model.projectName}", 
					   levelAchievements: "${teachAchievementsInfo.model.levelAchievements}",
					   Upload_Name: "${teachAchievementsInfo.model.submitUser.userName}",
					   timeAchievements: "${teachAchievementsInfo.model.timeAchievements}",
					   collegeAward: "${teachAchievementsInfo.model.collegeAward}",
					   remarks: "${teachAchievementsInfo.model.remarks}",
					   wordsNumber: "${teachAchievementsInfo.model.wordsNumber}",
					   firstChargeMan: "${teachAchievementsInfo.model.firstChargeMan}",
					   authorRank: "${teachAchievementsInfo.model.authorRank}",
					   publisher: "${teachAchievementsInfo.model.publisher}",
					   Status: "${teachAchievementsInfo.model.status}",
					   returnReason: "${teachAchievementsInfo.model.returnReason}",
					   approvedUser: "${teachAchievementsInfo.model.approvedUser.userName}",
					   type: "${type}"};
				rows.push(row);
    		 </script>
    </c:forEach>
     </c:if>
     </div> 
  </form>

<div style="display:none;">

</div>
</body>
</html>
