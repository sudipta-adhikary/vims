package edu.cts.academy.vi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cts.academy.vi.domain.dao.VehicleRegistrationDAO;
import edu.cts.academy.vi.domain.dao.VehicleRegistrationDAOImpl;
import edu.cts.academy.vi.domain.dao.ClaimAccidentalDAO;
import edu.cts.academy.vi.domain.dao.ClaimAccidentalDAOImpl;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.ClaimAccidentalForm;



@WebServlet("/ClaimPolicyController")
public class ClaimPolicyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dbStatus;
	
	ClaimAccidentalDAO cad=new ClaimAccidentalDAOImpl();
	VehicleRegistrationDAO vd=new VehicleRegistrationDAOImpl();
	List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//claimPolicyBean cpBean= new claimPolicyBean();
		@SuppressWarnings("unused")
		ClaimAccidentalForm caBean = new ClaimAccidentalForm();
		//cpBean.setPolicyID(request.getParameter("claimPolicyID"));
		String claimPolicyID = request.getParameter("claimPolicyID");
		String btnClaimAccidental = request.getParameter("claimTypeAccident");
		
		HttpSession session = request.getSession();
		session.setAttribute("claimPolicyID",claimPolicyID);
		

	   
		
		
		if(btnClaimAccidental!=null){
			
			 
		try{
			
			vList = cad.displayVehicle(claimPolicyID);
			
			
		    
			if (vList != null) {
				
				
				getServletContext().setAttribute("vList", vList);
				RequestDispatcher rd = request.getRequestDispatcher("claimAccidental.jsp");
				rd.forward(request, response);
			
			} }catch(Exception e){
				e.printStackTrace();
			}
		}
		
		/*String vehicleFirstName = request.getParameter("vehicleFirstName");
	    session.setAttribute("vehicleFirstName", vehicleFirstName);
	    String vehicleLastName = request.getParameter("vehicleLastName");
	    session.setAttribute("vehicleLastName", vehicleLastName);
	    String vehiclePremium = request.getParameter("vehiclePremium");
	    session.setAttribute("vehiclePremium", vehiclePremium);
	    String claimAccidentType = request.getParameter("claimAccidentType");
	    session.setAttribute("claimAccidentType", claimAccidentType);
	    String claimWeightage = request.getParameter("claimWeighatge");
	    session.setAttribute("claimWeightage", claimWeightage);
	    System.out.println(claimAccidentType);	
		*/
		
		
 String claimTypeTheft=request.getParameter("claimTypeTheft");
 if(claimTypeTheft!=null)
 {
	 try{
			
			vList = cad.displayVehicle(claimPolicyID);
			if (vList != null) {
				getServletContext().setAttribute("vList", vList);
				RequestDispatcher rd = request.getRequestDispatcher("claimTheft.jsp");
				rd.forward(request, response);
			
			} }catch(Exception e){
				e.printStackTrace();
			}
		}
 }
	
}

