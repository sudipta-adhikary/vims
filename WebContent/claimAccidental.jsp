<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ListIterator"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.cts.academy.vi.ui.form.VehicleRegistrationForm"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accidental Claim</title>
<script type="text/javascript">
function populate3(c1,c2){
	var c1=document.getElementById(c1);
	var c2=document.getElementById(c2);
	c2.innerHTML = "";
	if(c1.value == "fire"){
		var optionArray = ["|Select Weightage","80|80"];
	}
	else if(c1.value == "road"){
		var optionArray = ["|Select Weightage","70|70"];
	}
	else if(c1.value == "malicious"){
		var optionArray = ["|Select Weightage","50|50"];
	}
	else if(c1.value == "self"){
		var optionArray = ["|Select Weightage","40|40"];
	}
	if(c1.value == "part"){
		var optionArray = ["|Select Weightage","20|20"];
	}
	for(var option in optionArray){
		var pair = optionArray[option].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		c2.options.add(newOption);
	}
}
</script>
</head>
<body bgcolor=#F3C296>
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
			<td>Policy ID</td>
			<td><input type="text" name="caPolicyID" readonly="readonly" value="<%=vuBean.getPolicyID() %>"/></td>
		</tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="caFirstName" readonly="readonly" value="<%=vuBean.getVehicleFirstName()%>"/></td>
		</tr>	
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="caLastName" readonly="readonly" value="<%=vuBean.getVehicleLastName()%>"/></td>
		</tr>
		<tr>
			<td>Claim Amount</td>
			<td><input type="text" name="caClaim" readonly="readonly" value="<%=vuBean.getVehicleClaim()%>"/></td>
		</tr>
		<tr>	
			<td>Claim Date</td>
			<td><input type="text" name="caClaimDate" readonly="readonly" value="<%=vuBean.getVehicleClaimDate()%>"/></td>
		</tr>
		
		<%
			}
			}
		%>
		
		</table>
		<table>
		<tr>
		<td>Accident type:</td>
		<td><select name="claimAccidentType" onchange="populate3(this.id,'claimWeightage')" id="claimAccidentType">
			<option value=""></option>
			<option value="fire">Fire</option>
			<option value="road">Road Accident</option>
			<option value="malicious">Malicious Act</option>
			<option value="self">Self-destruction</option>
			<option value="part">Part Failure</option>
			</select>
		</td>
		</tr>
		<tr>
		<td>Weightage:</td>
		<td><select name="claimWeightage" id="claimWeightage"></select></td>
		</tr>
		
		<tr>
			<td><input type="submit" name="btnClaim" value="Claim"/></td>
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