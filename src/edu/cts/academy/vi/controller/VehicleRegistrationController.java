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
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;

@WebServlet("/VehicleRegistrationController")
public class VehicleRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String dbStatus;
	//VehicleRegistrationBean vuBean = new VehicleRegistrationBean();
	VehicleRegistrationDAO vd=new VehicleRegistrationDAOImpl();
	List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
		
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
		
		/************* Save Data ****************//*
		String btnSave = request.getParameter("btnSave");
		if (btnSave != null) {
			//vuBean.setPlanID(Integer.parseInt(request.getParameter("planID")));
			

			System.out.println(request.getParameter("vehicleType"));
			System.out.println(request.getParameter("vehiclePrice"));
			
			dbStatus = vd.registerVehicle(vuBean);
			
			if (!dbStatus.equals(null)) {
				HttpSession session = request.getSession();
				session.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("vehicleDetails.jsp");
			
		}*/
			//System.out.println("Hello");
		/************* Display Data ****************/
		String btnDisplay = request.getParameter("btnDisplay");
		System.out.println("Display: "+btnDisplay);
		if (btnDisplay != null) {
			try{
		
			System.out.println("Display2: "+btnDisplay);
			vList = vd.displayVehicle();
			if (vList != null) {
				getServletContext().setAttribute("vList", vList);
				RequestDispatcher rd = request.getRequestDispatcher("vehicleDetails.jsp");
				rd.forward(request, response);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		System.out.println("Display3: "+btnDisplay);
			

//		/************* Search Data ****************/
//		String btnSearch = request.getParameter("btnSearch");
//		if (btnSearch != null) {
//			vList = vd.searchVehicle(request.getParameter("vehicleEngineNo"));
//			if (vList != null) {
//				getServletContext().setAttribute("vList", vList);
//				RequestDispatcher rd = request.getRequestDispatcher("vehicleDetails.jsp");
//				rd.forward(request, response);
//			}
//		}

		/************* Delete Data ****************/
		String policyID = request.getParameter("deletePolicyID");
		if (policyID != null) {
			vList = vd.deletePolicy((policyID));
			if (vList != null) {
				getServletContext().setAttribute("vList", vList);
				RequestDispatcher rd = request.getRequestDispatcher("vehicleDetails.jsp");
				rd.forward(request, response);
			}
		}

		/************* Update Data ****************/
		String btnUpdate = request.getParameter("btnUpdate");
		if (btnUpdate != null) {
			VehicleRegistrationForm updateBean = new VehicleRegistrationForm();
			updateBean.setPolicyID(request.getParameter("editPolicyID"));
			updateBean.setVehicleFirstName(request.getParameter("vehicleFirstName"));
			updateBean.setVehicleLastName(request.getParameter("vehicleLastName"));
			updateBean.setVehicleState(request.getParameter("vehicleState"));
			updateBean.setVehicleClass(request.getParameter("vehicleClass"));
			updateBean.setVehicleType(request.getParameter("vehicleType"));
			updateBean.setVehicleManufacturer(request.getParameter("vehicleManufacturer"));
			updateBean.setVehicleModel(request.getParameter("vehicleModel"));
			updateBean.setVehicleEngineNo(request.getParameter("vehicleEngineNo"));
			updateBean.setVehicleYear(request.getParameter("vehicleYear"));
			updateBean.setVehicleLocation(request.getParameter("vehicleLocation"));
			updateBean.setVehiclePrice(request.getParameter("vehiclePrice"));
			updateBean.setVehicleDOP(request.getParameter("vehicleDOP"));
			dbStatus = vd.updateDeal(updateBean);
			if (!dbStatus.equals(null)) {
				HttpSession session = request.getSession();
				session.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("vehicleDetails.jsp");
			}
		}
	}

	}



