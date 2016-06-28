<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ListIterator"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.cts.academy.vi.ui.form.VehicleRegistrationForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cancel Policy</title>
<style type="text/css">
td {
	border-bottom: thin solid black;
	border-right: thin solid black;
	border-left: thin solid black;
	border-top: thin solid black;
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
<body onload="myFunction()" bgcolor=#EAE397>
<form action="CancelPolicyController">
<table align="center">
	<tr>
	<td colspan="2" align="center">
				<h1><b>Cancel Policy</b></h1>
			</td>
	</tr>
	<tr>
	<td>Policy ID:</td>
	<td><input type="text" name="cancelPolicyID"></td>
	</tr>
	<tr>
	<td>Cancellation Date:</td>
	<td><input type=text name="cancelDate" id="demo" readonly="readonly"></td>
	</tr>
	<tr>
			<td><input type="submit" name="btnCancelSubmit" value="Submit"/></td>
			<td><input type="submit" name="btnCancel" value="Cancel"/></td>
	</tr>
</table>
</form>
<!-- Display Data -->
	<%
		if (getServletContext().getAttribute("vList") != null) {
		List vList = (List) getServletContext().getAttribute("vList");
		ListIterator it = vList.listIterator();
	%>
	<table>
		<thead>
		<tr>
			<td>Delete</td>
			<td>Policy ID</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>State</td>
			<td>Class</td>
			<td>Type</td>
			<td>Manufacturer</td>
			<td>Model</td>
			<td>Engine No.</td>
			<td>Year</td>
			<td>Location</td>
			<td>Price</td>
			<td>DOP</td>
			<td>Premium</td>
			<td>Premium Date</td>
			<td>Claim</td>
			<td>Claim Date</td>
			</tr>
		</thead>
		<%
			while (it.hasNext()) {
		%>
		<%
			VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
					vuBean = (VehicleRegistrationForm) it.next();
					//String cancelPolicyID = (String) session.getAttribute("cancelPolicyID");
		%>
		<tr>
			<td><a href="CancelPolicyController?deletePolicyID=<%=vuBean.getPolicyID()%>"> <%=vuBean.getPolicyID()%></a></td>
			<td><%=vuBean.getPolicyID()%></td>
			<td><%=vuBean.getVehicleFirstName()%></td>
			<td><%=vuBean.getVehicleLastName()%></td>
			<td><%=vuBean.getVehicleState()%></td>
			<td><%=vuBean.getVehicleClass()%></td>
			<td><%=vuBean.getVehicleType()%></td>
			<td><%=vuBean.getVehicleManufacturer()%></td>
			<td><%=vuBean.getVehicleModel()%></td>
			<td><%=vuBean.getVehicleEngineNo()%></td>
			<td><%=vuBean.getVehicleYear()%></td>
			<td><%=vuBean.getVehicleLocation()%></td>
			<td><%=vuBean.getVehiclePrice()%></td>
			<td><%=vuBean.getVehicleDOP()%></td>
			<td><%=vuBean.getVehiclePremium()%></td>
			<td><%=vuBean.getVehiclePremiumDate()%></td>
			<td><%=vuBean.getVehicleClaim()%></td>
			<td><%=vuBean.getVehicleClaimDate()%></td>
		</tr>
		<%
			}
			}
		%>
		
		 <%
        if(request.getParameter("dbStatus")!=null){
            out.println(request.getAttribute("dbStatus"));
        }
    
    %>      
		</table>
</body>
</html>