<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pay Premium</title>
<style type="text/css">
form {
	margin: auto;
	border: thick solid gray;	
	background-attachment: scroll;
}
</style>
<script type="text/javascript">
function myFunction() {
	var dt = new Date();
	var dd;
	var mm;
	var yyyy;
	var date;
	var month;
	dd=dt.getDate();
	mm=dt.getMonth() +1 ;
	document.getElementById('demo').value = dd + '.' + mm + '.' + dt.getFullYear();
	}
</script>
</head>
<body onload="myFunction()" bgcolor=#DBE191>
<form action="SavePayController">
		<table align="center">
		<tr>
		<td>Policy ID:</td>
		<td><input type="text" name="pPolicyID"/></td>
		</tr>
		<tr>
		<td>Amount:</td>
		<td><input type="text" name="pPolicyAmount"/></td>
		</tr>
		<tr>
		<td>Payment Date:</td>
		<td><input type="date" name="pPolicyDate" id="demo" readonly="readonly"/></td>
		</tr>
		<tr>
		<td>Mode of Payment:</td>
		<td><input type="radio" name="policyPayMode" value="debit"/>Debit Card
		<input type="radio" name="policyPayMode" value="credit"/>Credit Card
		<input type="radio" name="policyPayMode" value="net"/>Net Banking</td>
		</tr>
		<tr>
		<td>Contact No.:</td>
		<td><input type="text" name="pPolicyContactNo"/></td>
		</tr>
		
		<tr>
			<td><input type="submit" name="btnPay" value="Pay"/></td>
			<td><input type="reset" name="btnReset" value="Reset"/></td>
		</tr> 
		
		
		
	<%
		if(request.getParameter("dbStatus")!=null){
			out.println(request.getAttribute("dbStatus"));
		}
	
	%>
		</table>
</form>
</body>
</html>