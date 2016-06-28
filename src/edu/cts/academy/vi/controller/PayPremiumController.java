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
import edu.cts.academy.vi.domain.dao.PayPremiumDAO;
import edu.cts.academy.vi.domain.dao.PayPremiumDAOImpl;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;

@WebServlet("/PayPremiumController")
public class PayPremiumController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String dbStatus;
	PayPremiumDAO ppd=new PayPremiumDAOImpl();
	VehicleRegistrationDAO vd=new VehicleRegistrationDAOImpl();
	List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//payRegisteredBean pdBean = new payRegisteredBean();
		String payPolicyID = request.getParameter("payPolicyID");
		String btnPayLogIn = request.getParameter("btnPayLogIn");
		
		HttpSession session = request.getSession();
		session.setAttribute("payPolicyID",payPolicyID);
		System.out.println(payPolicyID);
		String password = (String) session.getAttribute("password");
		String policyPassword = request.getParameter("policyPassword");
		if(btnPayLogIn!=null){
			System.out.println("hello");
			if(password.equals(policyPassword)){
			try{
			vList = ppd.displayVehicle(payPolicyID);
		    
			if (vList != null) {
				
				System.out.println("hi");
				getServletContext().setAttribute("vList", vList);
				RequestDispatcher rd = request.getRequestDispatcher("payRegistered.jsp");
				rd.forward(request, response);
			}
			} catch(Exception e){
				e.printStackTrace();
			}
		} else{
			RequestDispatcher rd = request.getRequestDispatcher("payPremiumForm2.jsp");
			rd.forward(request, response);
		}
		}
	}
	}


