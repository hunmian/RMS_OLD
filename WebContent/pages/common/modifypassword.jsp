<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改密码</title>
	<link href="/RMS/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />
    <script src="/RMS/js/jquery-1.4.4.min.js" type="text/javascript"></script> 
    <script src="/RMS/js/vanadium.js" type="text/javascript"></script>
	<script src="/RMS/js/check.js" type="text/javascript"></script>
    <style type="text/css">
		.clear{ clear:both;}
		body{ background:#E4E4E4;}
		#allpage{ background:#fff; padding-top:6px;}
		.content{ margin:20px 0;}
		.content form{ width:760px; margin:0 auto;}
		.content form label{ padding-right:18px; cursor:pointer; display:block; float:left; width:100px; text-align:right;}
		.content form input , .content form select{ margin-left:10px; width:20em;}
		.content form input:focus{ background:#F6F6F6;}
		.content form p{ margin:3em 0 0 20em;}
		.content form .add{ color:#F06274; padding-left:16px;}
		
		input.rightformcss,select.rightformcss,textarea.rightformcss{border:1px solid #5383F2;padding:1px;}
		.failmsg{color:#a40000;}
		input.failformcss,select.failformcss,textarea.failformcss{border:1px solid #F06274;padding:1px;}
		.content form input.btn{background:url(../../images/button.png) no-repeat; width:57px; height:25px; line-height:25px; color:#FFF; border:0; cursor:pointer;}
	</style>
</head>
<body style="padding:0px;">
	<div id="allpage">
		<div class="content">
			<form action="modifyPassword.action" method="post">
				<label for="oldPassword">原始密码</label>
				<input type="password" id="oldPassword" name="oldPassword" class=":required" />
				<br /><br />

				<label for="newPassword">新密码</label>
				<input type="password" id="newPassword" name="newPassword" class=":min_length;6 :max_length;16 :required" />
				<br /><br />
				
				<label for="confirm">确认密码</label>
				<input type="password" id="confirm" class=":same_as;newPassword" />
				<br /><br />
				<font color="red"><s:actionerror /></font>
				<p>
				<input type="submit" class="btn" value="修改" />
				<input type="reset" class="btn" value="重置"/>
				</p>
			</form>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>
</body>
</html>