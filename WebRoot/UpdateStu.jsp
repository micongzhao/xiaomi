<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@  page import="com.ittx.studentmanger.model.*"%>
<%@  page import="com.ittx.studentmanger.util.*"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>修改学生信息</title>
<style>
body {
	background-image: url('../mi1/img/1.jpg');
	background-size: 100%
}

h1 {
	text-align: center;
	font-size: 40px;
	font-family: "黑体";
	color: #D8D8D8;
}

.name {
	text-align: center;
}

input {
	border: 0;
}
</style>
</head>
<body>
	<%
		String number = request.getParameter("nums");
		System.out.println(">>>>>>>>number>>>>  "+number);
		Student student = StudentDB.getInstance().findStudentByNumber(
				Integer.parseInt(number));
		if(student == null){
		    out.println("学生为null");
		    return;
		}		
				System.out.println(">>>>>>>>student>>>>  "+student);
	%>
	<h1>修改学生信息</h1>
	<div class="name" Style="margin:200; height: 220px">


		<form style="height: 173px;"
			action="./updatestu.do" method="post"
			onsubmit="return check()">
			
				学生姓名:<input id="name" type="text" name="userName"value=<%=student.getName()%>			
				style="width: 232px; height:40px;border-radius:10px;"><br/><br/> 
				
				
				学生年龄:<input id="age" type="text" name="age"value=<%=student.getAge()%>				
				style="width: 237px; height:40px;border-radius:10px;"><br/>	<br/> 
				
				
				学生性别:<input type="text" id="sex" name="sex" placeholder="请输入学生性别"  value="<%=student.isSex()==true?"男":"女"%>"style="width: 237px; height:40px;border-radius:10px;"><br><br> 
				<input type="hidden" name="id"value=<%=student.getNumber()%>> 
				
				<input type="submit"value="提交" style="width: 90px; height: 37px;border-radius:10px;">

		</form>
	</div>
</body>
</html>
