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
import edu.cts.academy.vi.domain.dao.CancelPolicyDAO;
import edu.cts.academy.vi.domain.dao.CancelPolicyDAOImpl;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.CancelPolicyForm;

@WebServlet("/CancelPolicyController")
public class CancelPolicyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dbStatus;
	CancelPolicyDAO cpd=new CancelPolicyDAOImpl();
	VehicleRegistrationDAO vd=new VehicleRegistrationDAOImpl();
	List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cancelPolicyID = request.getParameter("cancelPolicyID");
		HttpSession session = request.getSession();
		session.setAttribute("cancelPolicyID", cancelPolicyID);
		CancelPolicyForm cpBean = new CancelPolicyForm();
		
		String btnCancelSubmit = request.getParameter("btnCancelSubmit");
		if (btnCancelSubmit!= null){
			vList = cpd.displayVehicle(cancelPolicyID);
			try{
				if (vList != null) {
				getServletContext().setAttribute("vList", vList);
				RequestDispatcher rd = request.getRequestDispatcher("cancelPolicyForm.jsp");
				rd.forward(request, response);
			} 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		String btnCancel = request.getParameter("btnCancel");
		if(btnCancel!= null){
			cpBean.setPolicyID(cancelPolicyID);
			cpBean.setCancelPolicyDate(request.getParameter("cancelDate"));
			dbStatus = cpd.savePolicy(cancelPolicyID,cpBean);
			if (!dbStatus.equals(null)) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("cancelPolicyForm.jsp");
		}
			}
		String policyID = request.getParameter("deletePolicyID");
		if (policyID != null) {
			dbStatus = cpd.deletePolicy(policyID);
			System.out.println(dbStatus);
			if (!dbStatus.equals(null)) {				
				session.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("cancelPolicyForm.jsp");			
		}
		}
		}
		}
