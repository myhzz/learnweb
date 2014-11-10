<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<html>
	<head>
		<title>using commons Upload to upload file</title>
	</head>
	<style>
* {
	font-family: "宋体";
	font-size: 14px
}
</style>
	<body>
		<p align="center">
			请您选择需要上传的文件
		</p>
		<form id="form1" name="form1" method="post"
			action="servlet/fileServlet" enctype="multipart/form-data">
			<table border="0" align="center">
				<tr>
					<td>
						上传人：
					</td>
					<td>
						<input name="name" type="text" id="name" size="20">
					</td>
				</tr>
					<tr>
					<td>
						上传类型：
					</td>
					<td>
						<input name="type" type="text" id="type" size="20">
					</td>
				</tr>
				<tr>
					<td>
						视频问题：
					</td>
					<td>
						<input name="type" type="text" id="problem" size="20"  >
					</td>
				</tr>
				<tr>
					<td>
						选项A：
					</td>
					<td>
						<input name="type" type="text" id="problemA" size="20"  >
					</td>
				</tr>
				<tr>
					<td>
						选项B：
					</td>
					<td>
						<input name="type" type="text" id="problemB" size="20"  >
					</td>
				</tr>
					<tr>
					<td>
						选项C：
					</td>
					<td>
						<input name="type" type="text" id="problemC" size="20"  >
					</td>
				</tr>
					<tr>
					<td>
						选项D：
					</td>
					<td>
						<input name="type" type="text" id="problemD" size="20"  >
					</td>
				</tr>
				<tr>
					<td>
						问题弹出时间：
					</td>
					<td>
						<input name="type" type="text" id="problemtime" size="20"  >
					</td>
				</tr>
				<tr>
					<td>
						视频内容简介：
					</td>
					<td>
						<input name="type" type="text" id="problemtime" size="20"  >
					</td>
				</tr>
				<tr>
					<td>
						上传视频：
					</td>
					<td>
						<input name="file" type="file" size="20">
					</td>
				</tr>
				<tr>
					<td>
						上传视频截图：
					</td>
					<td>
						<input name="file" type="file" size="20">
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" name="submit" value="提交">
						<input type="reset" name="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>