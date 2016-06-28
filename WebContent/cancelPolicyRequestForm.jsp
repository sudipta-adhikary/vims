<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User|Cancel</title>
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
<body onload="myFunction()">
<center>
<h1>
<font color=red>Policy Cancellation Request Form</font>
</h1>
</center>
<form action="CancelRequestController" method="post">
<center>
Enter Policy Number: <input type="text" name=policyID required=required>
<br/>
<br/>
Reason for Cancellation: <input type=textarea name=reason required=required>
<br/>
<br/>
Request Date: <input type=text name=requestDate readonly="readonly" id="demo">
<br/>
<br/>
<input type=submit name=submit value=Submit>
<input type="reset" name=reset value=Reset>
</center>
</form>
</body>
</html>