<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=#F5F5C7>
<form action="SignUpController">
<div align="center">
<br>
<br>
        <table align="center" cellspacing="10">
            <tr>
            <font face="verdana" size="25">Sign in to your account<br><br></font>
            </tr>
            <tr>
            <font face="calibri" size="5" color="red">Invalid Username/Password<br/>Please enter again</font>
            </tr>
            <tr>
                <td>Customer ID:</td>
                <td><input type="text" name="userName" required="required" size="40" /></td>
            </tr>
            <tr></tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required="required" size="40"></td>
            </tr>
            <tr></tr>
            <tr>
                <td></td>
                <td><input type="submit" name="btnSignIn" value="Sign In" /></td>
            </tr>
            <tr></tr>
            <tr><td>*Use your Customer ID as the login ID</td></tr>
            <tr></tr>
            
            <tr>
                <td>New User? Register here>>&nbsp;&nbsp;<a href="signUp.jsp" target="rightBar">Sign Up</a></td>
            </tr>
        </table>
        
</div>
    </form>

</body>
</html>