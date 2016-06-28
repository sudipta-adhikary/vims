<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ListIterator"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.cts.academy.vi.ui.form.VehicleRegistrationForm"%>
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
<form action="SavePayController">
<table align="center">
<!-- Display Data -->
	<%
		if (getServletContext().getAttribute("vList") != null) {
		List vList = (List) getServletContext().getAttribute("vList");
		ListIterator it = vList.listIterator();
	%>
	
		<%
				while (it.hasNext()) {
			%>
		<%
			VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
					vuBean = (VehicleRegistrationForm) it.next();
		%>
		<tr>
			<td>Policy ID</td>
			<td><input type="text" name="prPolicyID" readonly="readonly" value="<%=vuBean.getPolicyID() %>"/></td>
		</tr>
		<tr>
		<td>State:</td>
		<td><input type="text" readonly="readonly" name="prState" value="<%=vuBean.getVehicleState()%>"/></td>
		</tr>
	
		<tr>
		<td>Vehicle type:</td>
		<td><input type="text" readonly="readonly" name="prType" value="<%=vuBean.getVehicleType()%>"/></td>
	</tr>
		<tr>
		<td>Model:</td>
		<td><input type="text" readonly="readonly" name="prModel" value="<%=vuBean.getVehicleModel()%>"/></td>
		</tr>
		<tr>
			<td>Premium</td>
			<td><input type="text" name="prPremium" value="<%=vuBean.getVehiclePremium() %>" readonly="readonly"/></td>
		</tr>
		<tr>	
			<td>Premium Date</td>
			<td><input type="text" name="prPremiumDate" readonly="readonly" value="<%=vuBean.getVehiclePremiumDate()%>"/></td>
		</tr>
		
		<%
			}
			}
		%>
		
		<tr>
		<td>Mode of Payment:</td>
		<td><input type="radio" name="policyPayMode2" value="debit"/>Debit Card
		<input type="radio" name="policyPayMode2" value="credit"/>Credit Card
		<input type="radio" name="policyPayMode2" value="net"/>Net Banking</td>
		</tr>
		<tr>
		<td>Contact No.:</td>
		<td><input type="text" name="prContactNo2"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="btnPay2" value="Pay"/></td>
			<td><input type="reset" name="btnReset2" value="Reset"/></td>
		</tr> 
			
	<%
		if(request.getParameter("dbStatus")!=null) {
			out.println(request.getAttribute("dbStatus"));
		}
	
	%>
		</table>
	</form>
</body>
</html>