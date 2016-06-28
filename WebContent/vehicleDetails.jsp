<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ListIterator"%>
<%@ page import="java.util.*"%>
<%@ page import="edu.cts.academy.vi.ui.form.VehicleRegistrationForm"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Check Details of vehicle | Admin</title>
<script type="text/javascript">
function populate(s1,s2){
	var s1= document.getElementById(s1);
	var s2= document.getElementById(s2);
	s2.innerHTML = "";
	if(s1.value == "Two wheeler"){
		var optionArray = ["|Select Manufacturer","honda|HONDA","tvs|TVS","mahindra|MAHINDRA","bajaj|BAJAJ"];
	}
	else if(s1.value == "Four wheeler"){
		var optionArray = ["|Select Manufacturer","honda|HONDA","toyota|TOYOTA","hyundai|HYUNDAI","mahindra|MAHINDRA","chevrolet|CHEVROLET","skoda|SKODA","volks wagen|VOLKS WAGEN"];
	}
	for(var option in optionArray){
		var pair = optionArray[option].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		s2.options.add(newOption);
	}
}
function populate2(s2,s3){
	var s2= document.getElementById(s2);
	var s3= document.getElementById(s3);
	s3.innerHTML = "";
	if(s2.value == "honda"){
		var optionArray = ["|Select Model","splender|Splender","splender plus|Splender Plus","passion plus|Passion Plus","activa|Activa","accord|Accord","city|City","amaza|Amaze"];
	}
	else if(s2.value == "tvs"){
		var optionArray = ["|Select Model","victor glx|Victor GLX","sport|Sport","apache|Apache","xl super|XL Super","heavy duty|Heavy Duty","scooty pep|Scooty Pep"];
	}
	else if(s2.value == "mahindra"){
		var optionArray = ["|Select Model","duoro|Duoro","scorpio|Scorpio","xuv|XUV"];
	}
	else if(s2.value == "bajaj"){
		var optionArray = ["|Select Model","pulsar|Pulsar","discover|Discover","boxer|Boxer"];
	}
	else if(s2.value == "toyota"){
		var optionArray = ["|Select Model","etios|Etios"];
	}
	else if(s2.value == "hyundai"){
		var optionArray = ["|Select Model","venture|Venture","accent|Accent"];
	}
	else if(s2.value == "chevrolet"){
		var optionArray = ["|Select Model","tavera|TAVERA","spark|Spark"];
	}
	else if(s2.value == "skoda"){
		var optionArray = ["|Select Model","fabia|Fabia"];
	}
	else if(s2.value == "volks wagen"){
		var optionArray = ["|Select Model","punto|Punto"];
	}
	for(var option in optionArray){
		var pair = optionArray[option].split("|");
		var newOption = document.createElement("option");
		newOption.value = pair[0];
		newOption.innerHTML = pair[1];
		s3.options.add(newOption);
	}
}
</script>
<style type="text/css">
table {
	border: thin solid gray;
	margin: auto;
}

td {
	border-bottom: thin solid black;
	border-right: thin solid black;
	border-left: thin solid black;
	border-top: thin solid black;
}

tr:HOVER {
	background-color: coral;
	color: white;
}

</style>
</head>
<body bgcolor=#EAE397>
<form action="VehicleRegistrationController" method="post">
<!-- <input type="submit" name="btnDisplay" value="Display"/> -->

	<!-- Edit Data -->

		<%
			if (request.getParameter("editPolicyID") == null) {
		%>
		<table>
			<tr>
				<td>Policy ID:</td>
				<td><input type="text" name="policyID"></td>
			</tr>
			    <tr>
        <td>Vehicle Owner First Name:</td>
            <td><input type="text" name="vehicleFirstName" ></td>
    </tr> 
     <tr>
        <td>Vehicle Owner Last Name:</td>
            <td><input type="text" name="vehicleLastName"></td>
    </tr>            
    <tr>
        <td>Vehicle Registration State:</td>
        <td><select name="vehicleState">
        <option value="">Select State</option>
                <option value="1">Andhra Pradesh</option>
                <option value="2">Arunachal Pradesh</option>
                <option value="3">Assam</option>
                <option value="4">Bihar</option>
                <option value="5">Chhattisgarh</option>
                <option value="6">Goa</option>
                <option value="7">Gujarat</option>
                <option value="8">Haryana</option>
                <option value="9">Himachal Pradesh</option>
                <option value="10">Jammu and Kashmir</option>
                <option value="11">Jharkhand</option>
                <option value="12">Karnataka</option>
                <option value="13">Kerala</option>
                <option value="14">Madhya Pradesh</option>
                <option value="15">Maharashtra</option>
                <option value="16">Manipur</option>
                <option value="17">Meghalaya</option>
                <option value="18">Mizoram</option>
                <option value="19">Nagaland</option>
                <option value="20">Odisha</option>
                <option value="21">Punjab</option>
                <option value="22">Rajasthan</option>
                <option value="23">Sikkim</option>
                <option value="24">Tamil Nadu</option>
                <option value="25">Telangana</option>
                <option value="26">Tripura</option>
                <option value="27">Uttar Pradesh</option>
                <option value="28">Uttarakhand</option>
                <option value="29">West Bengal</option>
                <option value="30">Delhi(UT)</option>
                <option value="31">Puducherry(UT) </option>
                <option value="32">Andaman and Nicobar Islands(UT) </option>
                <option value="33">Chandigarh(UT) </option>
                <option value="34">Dadra and Nagar Haveli(UT) </option>
                <option value="35">Daman and Diu(UT) </option>
                <option value="36">Lakshadweep(UT) </option>
        </select></td>
    </tr>
    
    <tr>
    <td>Vehicle Class:</td>
    <td><select name="vehicleClass">
    <option value="">Select Class</option>
    <option value="1">Private</option>
    <option value="2">Public</option>
    </select>
    </td>
    </tr>
    
    
    
    <tr>
    
        <td>Vehicle type:</td>
        <td><select name="vehicleType" id="select1" onchange="populate(this.id,'select2')">
        <option value="">Select Type</option>
        <option value="Two wheeler">Two wheeler</option>
        <option value="Four wheeler">Four wheeler</option>
        </select></td>
    </tr>
    <tr>
        <td>Manufacturer:</td>
        <td><select name="vehicleManufacturer" id="select2" onchange="populate2(this.id,'select3')">
        <!-- <option value="">Select</option>
        <option value="1">HONDA</option>
        <option value="2">TVS</option>
        <option value="3">MAHINDRA</option>
        <option value="4">BAJAJ</option>
        <option value="5">TOYOTA</option>
        <option value="6">HYUNDAI</option>
        <option value="7">CHEVROLET</option>
        <option value="5">SKODA</option>
        <option value="5">VOLKS WAGEN</option> -->
        
        </select></td>
    </tr>
    <tr>
        <td>Model:</td>
        <td><select name="vehicleModel" id="select3">
        <!-- <option value="">Select</option>
        <option value="1">Splendar</option>
        <option value="2">Splendar Plus</option>
        <option value="3">Passion Plus</option>
        <option value="4">Activa</option>
        <option value="5">Victor GLX</option>
        <option value="6">Sport</option>
        <option value="7">Apache</option>
        <option value="8">XL Super</option>
        <option value="9">Heavy Duty</option>
        <option value="10">Scooty Pep</option>
        <option value="11">Duro</option>
        <option value="12">Pulsar</option>
        <option value="13">Discover</option>
        <option value="14">Boxer</option>
        <option value="15">Accord</option>
        <option value="16">City</option>
        <option value="17">Amaze</option>
        <option value="18">Etios</option>
        <option value="19">Venture</option>
        <option value="20">Accent</option>
        <option value="21">Scorpio</option>
        <option value="22">XUV</option>
        <option value="22">Tavera</option>
        <option value="23">Spark</option>
        <option value="24">Fabia</option>
        <option value="25">Punto</option> -->
        </select></td>
    </tr>
    <tr>
        <td>Engine number:</td>
            <td><input type="text" name="vehicleEngineNo"></td>
    </tr>    
    <tr>
        <td>Year of make:</td>
            <td><input type="date" name="vehicleYear"></td>
    </tr>    
    <tr>
        <td>Registering location:</td>
            <td><input type="text" name="vehicleLocation"></td>
    </tr>                            
    <tr>
        <td>Price:</td>
            <td>Rs. <input type="text" name="vehiclePrice"></td>
    </tr>            
    <tr>
        <td>Date of Purchase:</td>
            <td><input type="date" name="vehicleDOP"></td>
    </tr>  
			<tr>
				<td><input type="submit" name="btnSave" value="Save" /></td>
				<td><input type="submit" name="btnDisplay" value="Display"/></td>
			</tr>
</table>
		<%
			} 
			else if (request.getParameter("editPolicyID") != null) {
				VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
				String policyID = new String(request.getParameter("editPolicyID"));
				ArrayList editList = (ArrayList) getServletContext().getAttribute("vList");
				ListIterator it = editList.listIterator();
				while (it.hasNext()) {
					vuBean = (VehicleRegistrationForm)it.next();
					if (policyID == vuBean.getPolicyID()) {
						break;
					}
				}
		%>

		<table>
			<tr>
				<td>Policy ID:</td>
				<td><input type="text"
					style="background-color: orange; color: white;" readonly="readonly"
					name="editPolicyID" value="<%=request.getParameter("editPolicyID")%>" /></td>
			</tr>
			<tr>
        	<td>Vehicle Owner First Name:</td>
            <td><input type="text" style="background-color: pink; color: black;" name="vehicleFirstName" 
            value="<%=vuBean.getVehicleFirstName()%>"/></td>
			</tr>
			<tr>
				<td>Vehicle Owner Last Name:</td>
            <td><input type="text" name="vehicleLastName"
					style="background-color: pink; color: black;"
					value="<%=vuBean.getVehicleLastName()%>" /></td>
			</tr>
			<tr>
				<td>Vehicle Registration State:</td>
				<td><select name="vehicleState" style="background-color: pink; color: black;" >
       			 <option value="<%=vuBean.getVehicleState()%>"><%=vuBean.getVehicleState()%></option>
                <option value="1">Andhra Pradesh</option>
                <option value="2">Arunachal Pradesh</option>
                <option value="3">Assam</option>
                <option value="4">Bihar</option>
                <option value="5">Chhattisgarh</option>
                <option value="6">Goa</option>
                <option value="7">Gujarat</option>
                <option value="8">Haryana</option>
                <option value="9">Himachal Pradesh</option>
                <option value="10">Jammu and Kashmir</option>
                <option value="11">Jharkhand</option>
                <option value="12">Karnataka</option>
                <option value="13">Kerala</option>
                <option value="14">Madhya Pradesh</option>
                <option value="15">Maharashtra</option>
                <option value="16">Manipur</option>
                <option value="17">Meghalaya</option>
                <option value="18">Mizoram</option>
                <option value="19">Nagaland</option>
                <option value="20">Odisha</option>
                <option value="21">Punjab</option>
                <option value="22">Rajasthan</option>
                <option value="23">Sikkim</option>
                <option value="24">Tamil Nadu</option>
                <option value="25">Telangana</option>
                <option value="26">Tripura</option>
                <option value="27">Uttar Pradesh</option>
                <option value="28">Uttarakhand</option>
                <option value="29">West Bengal</option>
                <option value="30">Delhi(UT)</option>
                <option value="31">Puducherry(UT) </option>
                <option value="32">Andaman and Nicobar Islands(UT) </option>
                <option value="33">Chandigarh(UT) </option>
                <option value="34">Dadra and Nagar Haveli(UT) </option>
                <option value="35">Daman and Diu(UT) </option>
                <option value="36">Lakshadweep(UT) </option>
        </select></td>
			</tr>
			<tr>
				<td>Vehicle type:</td>
        <td><select name="vehicleType" style="background-color: pink; color: black;">
        <option value="<%=vuBean.getVehicleType()%>"><%=vuBean.getVehicleType()%></option>
        <option value="1">Two wheeler</option>
        <option value="2">Four wheeler</option>
        </select></td>
			</tr>
			<tr>
			<td>Manufacturer:</td>
        <td><select name="vehicleManufacturer" style="background-color: pink; color: black;">
        <option value="<%=vuBean.getVehicleManufacturer()%>"><%=vuBean.getVehicleManufacturer()%></option>
        <option value="1">HONDA</option>
        <option value="2">TVS</option>
        <option value="3">MAHINDRA</option>
        <option value="4">BAJAJ</option>
        <option value="5">TOYOTA</option>
        <option value="6">HYUNDAI</option>
        <option value="7">CHEVROLET</option>
        <option value="5">SKODA</option>
        <option value="5">VOLKS WAGEN</option>
        </select></td>
		</tr>
			<tr>
				<td>Model:</td>
        <td><select name="vehicleModel" style="background-color: pink; color: black;">
        <option value="<%=vuBean.getVehicleModel()%>"><%=vuBean.getVehicleModel()%></option>
        <option value="1">Splendar</option>
        <option value="2">Splendar Plus</option>
        <option value="3">Passion Plus</option>
        <option value="4">Activa</option>
        <option value="5">Victor GLX</option>
        <option value="6">Sport</option>
        <option value="7">Apache</option>
        <option value="8">XL Super</option>
        <option value="9">Heavy Duty</option>
        <option value="10">Scooty Pep</option>
        <option value="11">Duro</option>
        <option value="12">Pulsar</option>
        <option value="13">Discover</option>
        <option value="14">Boxer</option>
        <option value="15">Accord</option>
        <option value="16">City</option>
        <option value="17">Amaze</option>
        <option value="18">Etios</option>
        <option value="19">Venture</option>
        <option value="20">Accent</option>
        <option value="21">Scorpio</option>
        <option value="22">XUV</option>
        <option value="22">Tavera</option>
        <option value="23">Spark</option>
        <option value="24">Fabia</option>
        <option value="25">Punto</option>
        </select></td>
			</tr>
			<tr>
				<td>Engine number:</td>
            <td><input type="text" name="vehicleEngineNo" style="background-color: pink; color: black;"
					value="<%=vuBean.getVehicleEngineNo()%>" /></td>
			</tr>
			<tr>
				<td>Year of make:</td>
            <td><input type="date" name="vehicleYear" style="background-color: pink; color: black;"
					value="<%=vuBean.getVehicleYear()%>" /></td>
			</tr>
			<tr>
				<td>Registering location:</td>
            <td><input type="text" name="vehicleLocation" style="background-color: pink; color: black;"
					value="<%=vuBean.getVehicleLocation()%>" /></td>
			</tr>
			 <tr>
        <td>Price:</td>
            <td>Rs. <input type="text" name="vehiclePrice" style="background-color: pink; color: black;"
					value="<%=vuBean.getVehiclePrice()%>" /></td>
    </tr>            
    <tr>
        <td>Date of Purchase:</td>
            <td><input type="date" name="vehicleDOP" style="background-color: pink; color: black;"
					value="<%=vuBean.getVehicleDOP()%>" /></td>
    </tr>  
			<tr>
				<td><input type="submit" name="btnUpdate" value="Update" /></td>
				<td><input type="reset" name="btnCancel" value="Cancel" /></td>
			</tr>
</table>
		<%
			}
		%>
</form>

	<%-- <!-- Save Data -->
	<%
		if (session.getAttribute("dbStatus") != null) {
			out.println(session.getAttribute("dbStatus"));
			session.removeAttribute("dbStatus");
		}
	%>
 --%>

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
			<td>Edit</td>
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
			</tr>
		</thead>
		<%
			while (it.hasNext()) {
		%>
		<%
			VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
					vuBean = (VehicleRegistrationForm) it.next();
		%>
		<tr>
			<td><a
				href="vehicleRegistrationController?deletePolicyID=<%=vuBean.getPolicyID()%>"> <%=vuBean.getPolicyID()%>
			</a></td>
			<td><a href="vehicleDetails.jsp?editPolicyID=<%=vuBean.getPolicyID()%>">
					<%=vuBean.getPolicyID()%>
			</a></td>
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
		</tr>
		<%
			}
			}
		%>
	</table>
</body>
</html>