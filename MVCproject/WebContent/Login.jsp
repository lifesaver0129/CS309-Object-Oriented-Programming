<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	please login the system
	<br />
	<form action="LoginServlet" method="post">
		username: <input type="text" name="username"
			value="<%=request.getAttribute("username") != null ? request.getAttribute("username") : ""%>" />
		<%=request.getAttribute("msg_username") != null ? request.getAttribute("msg_username") : ""%>
		<br /> password:<input type="password" name="password"
			value="<%=request.getAttribute("password") != null ? request.getAttribute("password") : ""%>" />
		<%=request.getAttribute("msg_password") != null ? request.getAttribute("msg_password") : ""%><br />
		<input type="submit" value="login" /><br />
		<%=request.getAttribute("msg") != null ? request.getAttribute("msg") : ""%>
	</form>
	<a href="Register.jsp">Register a new account</a>
</body>
</html>