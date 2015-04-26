<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>导入股票资金数据</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	</head>

	<body>
<br /><br /><br />
		<div align="center">
		
		    <div>请上传文件：</div>
			<form action="<c:url value="action/importExcel.do"/>"
				enctype="multipart/form-data" method="post">
				<input type="file" name="excelFile" title="上传文件" width="300px" />
				<br/><br />
				<input type="submit" value="提交" />
				<br/><br />
			</form>
		</div>

	</body>
</html>
