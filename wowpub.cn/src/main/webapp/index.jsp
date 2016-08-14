<%@ page pageEncoding = "utf-8" contentType = "text/html" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<title>魔兽吧</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body background="img/background.jpg">
<br/>
<div id="title"><h1>欢迎光临魔兽吧</h1></div><br/>
<div>
	<form  class="center" action="createUser" method="post">
		用户名：<input name="name" placeholder="请输入用户名！"><br/><br/>
		密&nbsp;&nbsp;&nbsp;&nbsp;码：<input name="password" placeholder="请输入密码！"><br/><br/>
		<input type="submit" value="提交">
	</form>
</div>
</body>
</html>