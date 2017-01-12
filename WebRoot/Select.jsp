<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

		<title>查找学生界面</title>
		<style>
			body {background-image:url('../mi1/img/1.jpg');background-size:100%}
			h1{text-align:center;font-size: 40px;font-family:"黑体";color:#D8D8D8;}
			.name{text-align:center;}
			input{border:0;}
		</style>
	</head>
	<body>
	<h1>查找学生界面</h1>
		<div class="name" Style="margin:200; height: 220px">
		   <form style="height: 173px;"action="./Selecp.jsp" method="post" onsubmit="return check()">
		     学生姓名:<input type="text" name="number" placeholder="请输入学生编号" style="width: 232px; height:40px;border-radius:10px;"><br/><br/>
			    <input type="submit" value="提交" style="width: 90px; height: 37px;border-radius:10px;">
	         
		   </form>	
		</div>
	</body>
</html>
