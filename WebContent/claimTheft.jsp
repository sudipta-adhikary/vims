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
</head>
<body>
<form action="SaveClaimController">
<table>
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
		<td>First Name</td>
			<td><input type="text" name="ctFirstName" readonly="readonly" value="<%=vuBean.getVehicleFirstName()%>"/></td>
		</tr>	
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="ctLastName" readonly="readonly" value="<%=vuBean.getVehicleLastName()%>"/></td>
		</tr>
		<tr>
		<td>Total Claim Amount:</td>
		<td><input type="text" name="ctClaim" readonly="readonly" value="<%=vuBean.getVehicleClaim()%>"/></td>
		</tr>
		<tr>
		<td>Claim Date:</td>
		<td><input type="text" name="ctClaimDate" readonly="readonly" value="<%=vuBean.getVehicleClaimDate()%>"/></td>
		</tr>
		<%
			}
			}
		%>
		<tr>
		<td>Date of theft:</td>
		<td><input type="date" name="claimDateOfTheft"/></td>
		</tr>
		<tr>
		<td>Date of Complaint:</td>
		<td><input type="date" name="claimDateOfComplaint"/></td>
		</tr>
		<tr>
		<td>FIR Number:</td>
		<td><input type="text" name="claimFIRNo" size="10"/></td>
		</tr>
		<tr>
		<td>Police Station Branch:</td>
		<td><input type="text" name="claimPSBranch"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="btnClaim2" value="Claim"/></td>
			<td><input type="reset" name="btnReset2" value="Reset"/></td>
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