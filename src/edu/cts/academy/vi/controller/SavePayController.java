package edu.cts.academy.vi.controller;

import java.io.IOException;

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
import edu.cts.academy.vi.ui.form.PayDirectForm;
import edu.cts.academy.vi.ui.form.PayRegisteredForm;


@WebServlet("/SavePayController")
public class SavePayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String dbStatus;	
	PayPremiumDAO ppd=new PayPremiumDAOImpl();
	VehicleRegistrationDAO vd=new VehicleRegistrationDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		PayRegisteredForm pdBean = new PayRegisteredForm();
		PayDirectForm ppBean = new PayDirectForm();
		HttpSession session = request.getSession();
		String payPolicyID = (String) session.getAttribute("payPolicyID");
	
		String prState = request.getParameter("prState");
	    session.setAttribute("prState", prState);
	    String prType = request.getParameter("prType");
	    session.setAttribute("prType", prType);
	    String prModel = request.getParameter("prModel");
	    session.setAttribute("prModel", prModel);
	    
	    String prPremium = request.getParameter("prPremium");
		/*Double pr= null;
		pr=Double.parseDouble(prPremium2) * 0.0065;
		System.out.println(pr);
		String prPremium = String.valueOf(pr);
		System.out.println(prPremium);*/
		session.setAttribute("prPremium", prPremium);
	 
	  /*  Float prPremium = Float.valueOf(request.getParameter("prPremium"));
	    session.setAttribute("prPremium", prPremium);*/
	    
		 String pPolicyAmount = request.getParameter("pPolicyAmount");
		 /*Double pp= null;
		 pp=Double.parseDouble(pPolicyAmount2) * 0.0065;
		 System.out.println(pp);
		 String pPolicyAmount = (pp).toString();
		 System.out.println(pPolicyAmount);*/
		 session.setAttribute("pPolicyAmount", pPolicyAmount);
		 
		/*Float pPolicyAmount = (float) Integer.parseInt((request.getParameter("pPolicyAmount")));
	    session.setAttribute("pPolicyAmount", pPolicyAmount);*/
	    
	    
	    String prPremiumDate = request.getParameter("prPremiumDate");
	    session.setAttribute("prPremiumDate", prPremiumDate);
	
		String policyPayMode2 = request.getParameter("policyPayMode2");
	    session.setAttribute("policyPayMode2", policyPayMode2);
	    String prContactNo2 = request.getParameter("prContactNo2");
	    session.setAttribute("prContactNo2", prContactNo2);
	    
	    String pPolicyID = request.getParameter("pPolicyID");
	    session.setAttribute("pPolicyID", pPolicyID);
	    
	    String pPolicyDate = request.getParameter("pPolicyDate");
	    session.setAttribute("pPolicyDate", pPolicyDate);
	    
	    String policyPayMode =  request.getParameter("policyPayMode");
	    session.setAttribute("policyPayMode", policyPayMode);
	    
	    String pPolicyContactNo = request.getParameter("pPolicyContactNo");
	    session.setAttribute("pPolicyContactNo", pPolicyContactNo);
		
		System.out.println(payPolicyID);
		System.out.println(prModel);
		System.out.println(policyPayMode2);
		
		String btnPay2=request.getParameter("btnPay2");
		if(btnPay2!=null){
			
			pdBean.setPolicyID(payPolicyID);
			pdBean.setVehicleState(prState);
			pdBean.setPolicyVehicleType(prType);
			pdBean.setPolicyVehicleModel(prModel);
			pdBean.setPayPremium(prPremium);
			pdBean.setPayPremiumDate(prPremiumDate);
			pdBean.setPaymentMode(policyPayMode2);
			pdBean.setPayContactNo(prContactNo2);
		
				dbStatus = ppd.savePayRegistered(payPolicyID,pdBean);
			
			if (!dbStatus.equals(null)) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("paySuccessful.jsp");
		
		}
		}
	
		String btnPay=request.getParameter("btnPay");
		if(btnPay!=null){
			ppBean.setPolicyID(pPolicyID);
			ppBean.setPolicyPremium(pPolicyAmount);
			ppBean.setPolicyPremiumDate(pPolicyDate);
			ppBean.setPaymentMode(policyPayMode);
			ppBean.setContactNo(pPolicyContactNo);
			
			dbStatus = ppd.savePayDirect(pPolicyID,ppBean);
			
			if (!dbStatus.equals(null)) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("paySuccessful.jsp");
		}
		}

	}catch(Exception e){
		e.printStackTrace();
	}
	}
}


