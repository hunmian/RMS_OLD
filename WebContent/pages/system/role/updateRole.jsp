<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>修改角色</title>
		<link href="/RMS/css/admin/common.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="/RMS/js/jquery-1.4.2.js"></script>
		<script type="text/javascript" src="/RMS/js/admin/center.js"></script>
		<script type="text/javascript" src="/RMS/js/jquery.validate.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
			$("#myForm").validate({
				rules: {
					roleName: {
						required:true,
						maxlength:10
					},description: {
						required:true,
						maxlength:50
					}
				},messages: {
					roleName: {
						required:"请输入角色名",
						maxlength:"角色长度不能大于10"
					},description: {
						required:"请输入角色说明",
						maxlength:"角色描述的最大长度不超过50个字符"		
					}
				},success: function(label) {
					label.html("&nbsp;").addClass("checked");
				}	
			});
		});
		</script>
	</head>
	<body>
		<form id="myForm" action="updateRoleInfo.action" method="post">
			<div class="center">
				<div class="position">
					<div class="positionleft"></div>
					<div class="positionmiddle">
						<table class="positionmiddletable" cellpadding="0" cellspacing="0">
							<tr>
								<td style="vertical-align: middle; text-align: left;">
									<img src="/RMS/images/tb.gif" />
									<span style="font-size: 12px; font-weight: bold; margin-bottom: 15px;">你当前的位置:</span>[系统管理]-[角色管理]-[修改角色]
								</td>
								<td valign="bottom" style="text-align: right; vertical-align: middle;">
									<a href="javascript:window.history.back()"><img src="/RMS/images/44.png" />返回</a>
								</td>
							</tr>
						</table>
					</div>
					<div class="positionright"></div>
				</div>

				<div class="content">
					<table class="addtable" cellpadding="0" cellspacing="0">
						<tr>
							<td  align="right" width="40%">
								角色名称：
							</td>
							<td align="left">
								<input type="hidden" name="roleId" value="${role.roleId }" />
								<input type="text" name="roleName" value="${role.roleName }" />
							</td>
						</tr>
						<tr>
							<td align="right" width="40%">
								备注：
							</td>
							<td align="left">
								<textarea rows="5" cols="35" name="description">${role.description }</textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center" style="text-align: center;">
								<input type="submit" class="btn" value="保存" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<input type="reset" class="btn" name="重置" />
							</td>
						</tr>
					</table>
				</div>
				<div class="foot">
					<div class="footleft"></div>
					<div class="footmiddle">
					</div>
					<div class="footright">
					</div>
				</div>
			</div>
		</form>
	</body>
</html>