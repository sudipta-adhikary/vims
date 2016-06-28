<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="edu.cts.academy.vi.ui.form.VehicleRegistrationForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Claim Policy</title>
<style type="text/css">
form {
	margin: auto;
	border: thick solid gray;	
	background-attachment: scroll;
}
</style>
</head>
<body bgcolor=#F3C296>
<form action="ClaimPolicyController">
<table align="center">
	<tr>
	<td colspan="2" align="center">
				<h1><b>Claim Policy</b></h1>
			</td>
	</tr>
	<tr>
	<td>Policy ID:</td>
	<td><input type="text" name="claimPolicyID"></td>
	</tr>
	<tr>
			<td><input type="submit" name="claimTypeAccident" value="Accidental Claim"/></td>
			<td><input type="submit" name="claimTypeTheft" value="Theft Claim"/></td>
	</tr>
</table>
</form>
</body>
</html>