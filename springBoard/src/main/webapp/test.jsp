<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
<select name="filter_field">
	<option value="1">이름</option>
	<option value="2">ID</option>
	<option vaule="4">E-Mail</option>
</select>
<input type="hidden" name="" value="42">
Username: <input type="text" name="user" value="한글이름">
<br>
Password: <input type="password" name="pwd" value="1234">
<br>
<input type="text" name="aaa" value="12">
<input type="hidden" name="" value="62">
<input type="hidden" name="bbb" value="">
<input type="submit" value="Login">
</form>
</body>
</html>