<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
	
		<title>添加学生</title>
		<style>
			body {background-image:url('../mi1/img/1.jpg');background-size:100%}
			h1{text-align:center;font-size: 40px;font-family:"黑体";color:#D8D8D8;}
			.name{text-align:center;}
			input{border:0;}
		</style>
	</head>
	<body>
	<h1>添加学生</h1>
		<div class="name" Style="margin:200; height: 220px">
		   <form style="height: 173px;"action="./addStudentservlet.do" method="post" onsubmit="return check()">
				     学生姓名:<input id="name" type="text" name="userName" placeholder="请输入学生姓名" style="width: 232px; height:40px;border-radius:10px;"><br/><br/>
				     学生编号:<input id="number" type="text" name="number" placeholder="请输入学生编号" style="width: 237px; height:40px;border-radius:10px;"><br/><br>		    
				     学生年龄:<input id="age" type="text" name="age" placeholder="请输入学生年龄" style="width: 237px; height:40px;border-radius:10px;"><br/><br>
		     <% if("false".equals(request.getParameter("flag"))) {%>
				<span>添加学生已经存在!</span>
			<% }%>
			    <input type="submit" value="提交" style="width: 90px; height: 37px;border-radius:10px;">	         
		   </form>			   
		</div>
			
	</body>
</html>
