package edu.cts.academy.vi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cts.academy.vi.domain.dao.VehicleSaveDAO;
import edu.cts.academy.vi.domain.dao.VehicleSaveDAOImpl;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;

@WebServlet("/VehicleSaveController")
public class VehicleSaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	String dbStatus;
	//VehicleRegistrationBean vuBean = new VehicleRegistrationBean();
	VehicleSaveDAO vd=new VehicleSaveDAOImpl();
	List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
		HttpSession session = request.getSession();
		
		String vehiclePrice = request.getParameter("vehiclePrice");
		double vehiclePriceInt=Integer.parseInt(vehiclePrice);
		String vehicleClass=(String)request.getParameter("vehicleClass");
		double pa= vehiclePriceInt * 0.065;
		double tax = Double.parseDouble(vehiclePrice) * 0.034;
		String premiumAmount = null;
		
		 String vehicleRegDate = request.getParameter("vehicleRegDate");
		 String vRegYear=vehicleRegDate.substring(5,9);
		 System.out.println(vRegYear);
		 String vRegMonth = vehicleRegDate.substring(3,4);
		 int vRegMonthDemo = Integer.parseInt(vRegMonth);
		 String vRegDate = vehicleRegDate.substring(0, 5);
		 int pDateDemo = Integer.parseInt(vRegYear);
		 int cDateDemo = pDateDemo + 10;
		 pDateDemo = pDateDemo + 1;
		 
		 String premiumDate = vRegDate + String.valueOf(pDateDemo);
		 String claimDate = vRegDate + String.valueOf(cDateDemo);
		 session.setAttribute("claimDate", claimDate);
		 session.setAttribute("vehicleRegDate", premiumDate);	
		
		 String vDOP=(String)request.getParameter("vehicleDOP");
		 String sDOP=vDOP.substring(5,9);
		 int sDOPDemo = Integer.parseInt(sDOP);
		 String sDOP2 = vDOP.substring(3,4);
		 int sDOP2Demo = Integer.parseInt(sDOP2);
	     
		 String vMakeYear=(String)request.getParameter("vehicleYear");
	     int vMakeYearDemo=Integer.parseInt(vMakeYear);
	     
	     int yDifference = vMakeYearDemo - sDOPDemo;
	     int mDifference = sDOP2Demo - vRegMonthDemo;
	   
	        double insuranceAmount=0;
	        if(yDifference>=5)
	        {
	        	insuranceAmount = vehiclePriceInt * 0.5;
	        }
	        else
	        {
	        	insuranceAmount = vehiclePriceInt * 1.02;
	        }
	        
	        String vehicleClaim = String.valueOf(insuranceAmount);
	        if(insuranceAmount <= vehiclePriceInt * 0.02){
	        	session.setAttribute("vehicleClaim", vehicleClaim);
	        }
		
		 if(vehicleClass.equalsIgnoreCase("Public"))
	        {
	        	pa=pa+tax;
	        	System.out.println(pa);
	        	if(yDifference==0)
		        {
		        	if((mDifference)<=3)
		        	{
		        		pa=pa*0.97;
		        	}
		        }
		        else if(yDifference==1)
		        {
		        	if(mDifference<=9)
		        	{
		        		pa=pa*0.97;
		        	}
		        }
	    		premiumAmount = String.valueOf(pa);
	    		System.out.println(premiumAmount);
	    		//String premiumAmount = ((Float.valueOf((vehiclePrice))*0.0065));
	    		//session.setAttribute("premiumAmount", premiumAmount);
	    		
	        }
	        else if(vehicleClass.equalsIgnoreCase("Private"))
	        {
	        	
	    		System.out.println(pa);
	    		if(yDifference==0)
		        {
		        	if((mDifference)<=3)
		        	{
		        		pa=pa*0.97;
		        	}
		        }
		        else if(yDifference==1)
		        {
		        	if(mDifference<=-9)
		        	{
		        		pa=pa*0.97;
		        	}
		        }
	    		premiumAmount = String.valueOf(pa);
	    		System.out.println(premiumAmount);
	    		//String premiumAmount = ((Float.valueOf((vehiclePrice))*0.0065));
	    		//session.setAttribute("premiumAmount", premiumAmount);
	        }
		
		 session.setAttribute("premiumAmount", premiumAmount);
		 
			
		
		 
		 
		vuBean.setVehicleFirstName(request.getParameter("vehicleFirstName"));
		vuBean.setVehicleLastName(request.getParameter("vehicleLastName"));
		vuBean.setVehicleState(request.getParameter("vehicleState"));
		vuBean.setVehicleClass(request.getParameter("vehicleClass"));
		vuBean.setVehicleType(request.getParameter("vehicleType"));
		vuBean.setVehicleManufacturer(request.getParameter("vehicleManufacturer"));
		vuBean.setVehicleModel(request.getParameter("vehicleModel"));
		vuBean.setVehicleEngineNo(request.getParameter("vehicleEngineNo"));
		vuBean.setVehicleYear(request.getParameter("vehicleYear"));
		vuBean.setVehicleLocation(request.getParameter("vehicleLocation"));
		vuBean.setVehiclePrice(request.getParameter("vehiclePrice"));
		vuBean.setVehicleDOP(request.getParameter("vehicleDOP"));
		vuBean.setVehiclePremium(premiumAmount);
		vuBean.setVehiclePremiumDate(premiumDate);
		vuBean.setVehicleClaim(vehicleClaim); /* Total Insurance Amount*/
		vuBean.setVehicleClaimDate(claimDate);
		
		/************* Save Data ****************/
		String btnSave = request.getParameter("btnSave");
		if (btnSave != null) {
			//vuBean.setPlanID(Integer.parseInt(request.getParameter("planID")));
			

			System.out.println(request.getParameter("vehicleType"));
			System.out.println(request.getParameter("vehiclePrice"));
			
			dbStatus = vd.registerVehicle(vuBean);
			
			if (!dbStatus.equals(null)) {
				
				session.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("vehicleRegistrationForm.jsp");
			
		}
			//System.out.println("Hello");
	}

}
}