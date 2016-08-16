<%@ page pageEncoding = "utf-8" contentType = "text/html" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<title>魔兽吧</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<!--  <body background="img/background.jpg"> -->
<body>
<br/>
<div id="title"><h1>欢迎光临魔兽吧</h1></div><br/>
<div>
	<form  class="center" action="createUser" method="post">
		用户名称:<input name="userName" placeholder="请输入用户名！" width = 200><br/><br/>
		用户密码:<input type="password" name="userPassword" placeholder="请输入密码！" width = 200><br/><br/>
		密码确认:<input type="password" name="confirmPwd" placeholder="请重新输入密码！" width = 200><br/><br/>
		常用邮箱:<input name="email" placeholder="请输入常用邮箱  !" width = 200><br/><br/>
		<input type="submit" value="提交">
	</form>
</div>
</body>
</html>