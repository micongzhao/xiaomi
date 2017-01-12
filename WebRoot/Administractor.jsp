
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@  page import="com.ittx.studentmanger.model.*"%>
<%@  page import="com.ittx.studentmanger.util.*"%>
<%@  page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>员工表</title>
<style>

table {
	width: 100%;
	height: 60px;
	border-collapse: collapse; /*设置表格的边框折叠成一个单一的边框*/
	margin: 0 auto; /*设置表格居中*/
	background-color: white;
}

table,tr,td,th {
	border: 1px solid black; /*边框：大小 实线 颜色*/
	text-align: center; /*表格内容居中*/
	padding: 10px; /*内边距*/
}

th {
	background-color: green;
	color: white;
}

tr:hover {
	background-color: #b0c4de;
	color: white;
}

a {
	text-decoration: none; /*移除鼠标下划线*/
	background-color: #008000;
	padding: 7px;
}

a:link,a:visited {
	display: block; /*行元素->块元素*/
	color: white; /* 未访问链接*/
}

a:hover,a:active { /* 鼠标移动到链接上 */
	color: #FF00FF;
	background-color: #7A991A;
}

table {
	border: 0;
}

</style>
<%
		AdministractorDB administractor=AdministractorDB.getInstance();
		  ArrayList<Administractor> studentList = administractor.getAllAdministractor();
    session.setAttribute("list", studentList);
%>
</head>
<body>
 
	<div>
		<table>
			<caption>用户信息表</caption>
			<tr>
				
				<th>用户名</th>
				<th>密码</th>
				<th colspan="2">操作</th>				
			</tr>
			
		<c:forEach items="${studentList}" var="administractor">
			<tr>
			  
		
				<td>${administractor.userName}</td>
				<td>${administractor.passWord}</td>
				
	 
				<td><a href="./deleteservlet.do?num=<c:out value="${student.number}"></c:out>">删除</a></td>
				<td><a href="./UpdateStu.jsp?nums=${student.number}">修改</a></td>			
			</tr>			
		</c:forEach>

		</table>

	</div>
</body>
</html>
