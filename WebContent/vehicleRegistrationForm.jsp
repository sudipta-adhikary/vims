<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vehicle Registration by Admin</title>
<script type="text/javascript">
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
<%-- <% String date="dd-mm-yyyy" ;
SimpleDateFormat sdf=new SimpleDateFormat();
Dat

%> --%>
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
	
	function walert(){
		alert("Registration Succesful");
	}
</script>
<style type="text/css">
form {
    margin: auto;
    border: thick solid gray;    
    background-attachment: scroll;
}
</style>
</head>
<body onload="myFunction()" bgcolor=#EAE397>
<form action="VehicleSaveController" method="post">
    <table align="center" >
    <tr><td colspan="2" align="center"><h1><b>Vehicle Registration</b></h1></td></tr>
    <tr>
        <td>Vehicle Owner First Name:</td>
            <td><input type="text" name="vehicleFirstName" required="required"></td>
    </tr> 
     <tr>
        <td>Vehicle Owner Last Name:</td>
            <td><input type="text" name="vehicleLastName" required="required"></td>
    </tr>            
    <tr>
        <td>Vehicle Registration State:</td>
        <td><select name="vehicleState" id="vehicleState">
        <option value="">Select State</option>
                <option value="Andhra Pradesh">Andhra Pradesh</option>
                <option value="Arunachal Pradesh">Arunachal Pradesh</option>
                <option value="Assam">Assam</option>
                <option value="Bihar">Bihar</option>
                <option value="Chhattisgarh">Chhattisgarh</option>
                <option value="Goa">Goa</option>
                <option value="Gujarat">Gujarat</option>
                <option value="Haryana">Haryana</option>
                <option value="Himachal Pradesh">Himachal Pradesh</option>
                <option value="Jammu and Kashmir">Jammu and Kashmir</option>
                <option value="Jharkhand">Jharkhand</option>
                <option value="Karnatak">Karnataka</option>
                <option value="Kerala">Kerala</option>
                <option value="Madhya Pradesh">Madhya Pradesh</option>
                <option value="Maharashtra">Maharashtra</option>
                <option value="Manipur">Manipur</option>
                <option value="Meghalaya">Meghalaya</option>
                <option value="Mizoram">Mizoram</option>
                <option value="Nagaland">Nagaland</option>
                <option value="Odisha">Odisha</option>
                <option value="Punjab">Punjab</option>
                <option value="Rajasthan">Rajasthan</option>
                <option value="Sikkim">Sikkim</option>
                <option value="Tamil Nadu">Tamil Nadu</option>
                <option value="Telangana">Telangana</option>
                <option value="Tripura">Tripura</option>
                <option value="Uttar Pradesh">Uttar Pradesh</option>
                <option value="Uttarakhand">Uttarakhand</option>
                <option value="West Bengal">West Bengal</option>
                <option value="Delhi(UT)">Delhi(UT)</option>
                <option value="Puducherry(UT)">Puducherry(UT)</option>
                <option value="Andaman and Nicobar Islands(UT)">Andaman and Nicobar Islands(UT)</option>
                <option value="Chandigarh(UT)">Chandigarh(UT)</option>
                <option value="Dadra and Nagar Haveli(UT)">Dadra and Nagar Haveli(UT)</option>
                <option value="Daman and Diu(UT)">Daman and Diu(UT)</option>
                <option value="Lakshadweep(UT)">Lakshadweep(UT)</option>
        </select></td>
    </tr>
    
    <tr>
    <td>Vehicle Class:</td>
    <td><select name="vehicleClass">
    <option value="">Select Class</option>
    <option value="Private">Private</option>
    <option value="Public">Public</option>
    </select>
    </td>
    </tr>
    
    
    
    <tr>
    
        <td>Vehicle type:</td>
        <td><select name="vehicleType">
        <option value="">Select Type</option>
        <option value="Two wheeler">Two wheeler</option>
        <option value="Four wheeler">Four wheeler</option>
        </select></td>
    </tr>
    <tr>
        <td>Manufacturer:</td>
        <td><select name="vehicleManufacturer" id="select1" onchange="populate2(this.id,'select2')">
        <option value="">Select</option>
        <option value="honda">HONDA</option>
        <option value="tvs">TVS</option>
        <option value="mahindra">MAHINDRA</option>
        <option value="bajaj">BAJAJ</option>
        <option value="toyota">TOYOTA</option>
        <option value="hyundai">HYUNDAI</option>
        <option value="chevrolet">CHEVROLET</option>
        <option value="skoda">SKODA</option>
        <option value="volks wagen">VOLKS WAGEN</option>
        
        </select></td>
    </tr>
    <tr>
        <td>Model:</td>
        <td><select name="vehicleModel" id="select2">
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
            <td><input type="text" name="vehicleEngineNo" required="required"></td>
    </tr>    
    <tr>
        <td>Year of make:</td>
            <td><input type="text" name="vehicleYear"></td>
    </tr>    
    <tr>
        <td>Registering location:</td>
            <td><input type="text" name="vehicleLocation" required="required"></td>
    </tr>                            
    <tr>
        <td>Price:</td>
            <td>Rs. <input type="text" name="vehiclePrice" required="required"></td>
    </tr>            
    <tr>
        <td>Date of Purchase:</td>
            <td><input type="text" name="vehicleDOP"></td>
    </tr>   
    <tr>
        <td>Date of Registration:</td>
            <td><input type="text" name="vehicleRegDate" readonly="readonly" id="demo"></td>
    </tr>    
    <tr>
        <td></td>
            <td><input type="submit" name="btnSave" value="Register" onsubmit="walert()"/></td>
           	
    </tr>    
   
    <%
        if(request.getParameter("dbStatus")!=null){
            out.println(request.getAttribute("dbStatus"));
        }
    
    %>            
    </table>
     <a href="vehicleDetails.jsp" target="rightBar">For edit and delete click here</a>
</form>
</body>
</html>