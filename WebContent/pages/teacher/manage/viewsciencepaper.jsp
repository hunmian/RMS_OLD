<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%    
      String path = request.getContextPath();
      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
       
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath%>">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人理科论文信息</title>
	<link href="lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
	<link href="lib/ligerUI/skins/ligerui-icons.css" rel="stylesheet" type="text/css" />
    <link href="css/Data.css" rel="stylesheet" type="text/css" />
    <script src="lib/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
    <script src="lib/ligerUI/js/ligerui.min.js" type="text/javascript"></script>
    <script src="js/teacher/viewSciencePaper.js" type="text/javascript"></script>
</head>
<body style="padding:0px; overflow:hidden;">
	<div class="l-loading" style="display:block" id="pageloading"></div> 
  	<form id="form1"> 
		<div id="toptoolbar"></div> 
    	<div id="maingrid" style="margin:0; padding:0">
    		<s:iterator value="sciencePaperList">
     			<script type="text/javascript">
					var row = {Paper_ID: "${paperId}", Paper_Name: "${paperName}", Subject: "${subjectsIn}", 
							Post_Publication: "${postPublication}", Include: "${includeSituation}", Published_Time: "${publishedTime}", 
							Title_Number: "${titleNumber}", Awarding_Grades: "${awardingGrades}", Total_Prize: "${totalPrize}", 
							Papers_Units: "${papersUnits}", Status: "${status}"};
					rows.push(row);
     			</script> 
   			</s:iterator> 
    	</div>
	</form>

  	<div style="display:none;">
	</div>
	
</body>
</html>