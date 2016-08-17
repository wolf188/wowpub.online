<%@ page pageEncoding="utf-8" isELIgnored="false" language="java" %>
<html>
<head>
<meta charset="utf-8">
<title>魔兽吧-用户登陆</title>
<link rel="stylesheet" href="../css/login.css">
</head>
<body background="../img/loginBackGround.jpg">
<h3 class="center">魔兽吧用户登陆</h3>
<form class="center" action="login" method="post">
用户名称：<input name="userName" >&nbsp;${userInfo.msgMap.userName}<br/><br/>
用户密码：<input type="password" name="userPassword">&nbsp;${userInfo.msgMap.password}<br/><br/>
<input type="submit" value="登陆">
</form>
</body>
</html>