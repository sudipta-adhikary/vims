<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
form {
	margin: auto;
	border: thick solid gray;	
	background-attachment: scroll;
}
</style>
</head>
<body bgcolor=#C8F198>
<form action="PayPremiumController">
		<table align="center">
		<tr>
		<td>Policy ID:</td>
		<td><input type="text" name="payPolicyID"/></td>
		</tr>
		
		<tr>
		<td>Password:</td>
		<td><input type="password" name="policyPassword"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="btnPayLogIn" value="Login"/></td>
		</tr>
	
		</table>
	</form>
</body>
</html>