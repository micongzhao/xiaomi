<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">
	function check() {
		$("#error").text(""); //文本内容
		var user = $("#user").val(); //获取表单元素值
		var psw = $("#psw").val();

		if (user == "" || psw == "") {
			$("#msg").text("用户名和密码不能为空！");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>
	<div class="bg"></div>
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<%
					String userName = "";
					String passWord = "";
					Cookie[] cookies = request.getCookies();
					if (cookies != null && cookies.length > 0) {
						for (Cookie c : cookies) {
							if (c.getName().equals("name")) {
								userName = c.getValue();
							} else if (c.getName().equals("psw")) {
								passWord = c.getValue();
							}

						}
					}
				%>
				<form action="./login.do" method="post">
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>后台管理中心</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input id="user" type="text" class="input input-big"
										name="userName" placeholder="登录账号" value="<%=userName%>"
										data-validate="required:请填写账号" /> <span
										class="icon icon-user margin-small"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input id="pass" type="password" class="input input-big"
										name="passWord" placeholder="登录密码" value="<%=passWord%>"
										data-validate="required:请填写密码" /> <span
										class="icon icon-key margin-small"></span>
								</div>
							</div>
						</div>
						<div style="padding: 30px;">
							<input type="submit"
								class="button button-block bg-main text-big input-big"
								value="登录"> <span style="color: red">保存登录状态</span><br />
							<%
								//java后端 判断用户名和密码是否正确
								String isSucess = request.getParameter("isSucuess");
								if ("false".equals(isSucess)) {
							%>
							<span id="error">用户名或密码出错!</span>
							<%
								}
							%>
							 <input type="checkbox" name="autoLogin" value="true"checked="checked">
							  <span id="msg"></span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>