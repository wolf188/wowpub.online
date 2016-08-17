<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html lang="zh-cn">
<head>
	<meta charset="UTF-8">
	<title>魔兽吧</title>
	<link rel="stylesheet" href="../css/style.css">
</head>
<body background="../img/background.jpg">
<br/>
<div id="title"><h2>欢迎光临魔兽吧</h2></div><br/>
<div>
	<form  class="center" action="createUser" method="post">
		用户名称:<input name="userName" value="${registInfo.userName}"  width = 200 placeholder="请输入用户名！">&nbsp;${registInfo.msgMap.userName}<br><br>
		用户密码:<input type="password" name="userPassword" value = "${registInfo.userPassword }" placeholder="请输入密码！"  width = 200>&nbsp;${registInfo.msgMap.userPassword}<br/><br/>
		密码确认:<input type="password" name="confirmPwd" value = "${registInfo.confirmPwd }" placeholder="请重新输入密码！"  width = 200>&nbsp;${registInfo.msgMap.confirmPwd}<br/><br/>
		常用邮箱:<input type="email" name="email" placeholder="请输入常用邮箱  !" value = "${registInfo.email }" width = 200>&nbsp;${registInfo.msgMap.email}<br/><br/>
		<input type="submit" value="提交">
	</form>
</div>
</body>
</html>