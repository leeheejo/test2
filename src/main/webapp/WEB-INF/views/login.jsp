<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form name="LoginForm" method="post" action="login.do">
		<!-- <form method="get"> -->
		<div class="input-group input-group-lg">
			<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
				type="text" name="u_id" class="form-control"
				placeholder="Username or email">
		</div>
		<br>
		<div class="input-group input-group-lg">
			<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
				type="password" name="u_pwd" class="form-control"
				placeholder="Password">
		</div>
		<br>
		<button type="submit">login</button>
	</form>
</body>
</html>