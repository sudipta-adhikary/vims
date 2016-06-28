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
import edu.cts.academy.vi.domain.dao.ClaimAccidentalDAO;
import edu.cts.academy.vi.domain.dao.ClaimAccidentalDAOImpl;
import edu.cts.academy.vi.ui.form.ClaimAccidentalForm;
import edu.cts.academy.vi.ui.form.ClaimTheftForm;

@WebServlet("/SaveClaimController")
public class SaveClaimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String dbStatus;
	
	ClaimAccidentalDAO cad=new ClaimAccidentalDAOImpl();
	VehicleRegistrationDAO vd=new VehicleRegistrationDAOImpl();
	//List<VehicleRegistrationBean> vList = new ArrayList<VehicleRegistrationBean>();    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClaimAccidentalForm caBean = new ClaimAccidentalForm();
		ClaimTheftForm ctBean = new ClaimTheftForm();
		
		HttpSession session = request.getSession();
		String claimPolicyID = (String) session.getAttribute("claimPolicyID");
	
		String caFirstName = request.getParameter("caFirstName");
	    session.setAttribute("caFirstName", caFirstName);
	    String caLastName = request.getParameter("caLastName");
	    session.setAttribute("caLastName", caLastName);
	    String caClaim = request.getParameter("caClaim");
	    session.setAttribute("caClaim", caClaim);
	    String caClaimDate = request.getParameter("caClaimDate");
	    session.setAttribute("caClaimDate", caClaimDate);
	
		String claimAccidentType = request.getParameter("claimAccidentType");
	    session.setAttribute("claimAccidentType", claimAccidentType);
	    String claimWeightage = request.getParameter("claimWeightage");
	    session.setAttribute("claimWeightage", claimWeightage);
	    
	    String ctFirstName = request.getParameter("ctFirstName");
	    session.setAttribute("ctFirstName", ctFirstName);
	    String ctLastName = request.getParameter("ctLastName");
	    session.setAttribute("ctLastName", ctLastName);
	    String ctClaim = request.getParameter("ctClaim");
	    session.setAttribute("ctClaim", ctClaim);
	    String ctClaimDate = request.getParameter("ctClaimDate");
	    session.setAttribute("ctClaimDate", ctClaimDate);
	    
	    String claimDateOfTheft = request.getParameter("claimDateOfTheft");
	    session.setAttribute("claimDateOfTheft", claimDateOfTheft);
	    String claimDateOfComplaint = request.getParameter("claimDateOfComplaint");
	    session.setAttribute("claimDateOfComplaint", claimDateOfComplaint);
	    String claimFIRNo = request.getParameter("claimFIRNo");
	    session.setAttribute("claimFIRNo", claimFIRNo);
	    String claimPSBranch = request.getParameter("claimPSBranch");
	    session.setAttribute("claimPSBranch", claimPSBranch);
		
		System.out.println(claimPolicyID);
		System.out.println(caFirstName);
		System.out.println(claimAccidentType);
		System.out.println(claimWeightage);
		
		String btnClaim=request.getParameter("btnClaim");
		
		if(btnClaim!=null){
			
			caBean.setPolicyID(claimPolicyID);
			caBean.setVehcileFirstName(caFirstName);
			caBean.setVehcileLastName(caLastName);
			caBean.setVehicleClaim(caClaim);
			caBean.setVehicleClaimDate(caClaimDate);
			caBean.setAccidentType(claimAccidentType);
			caBean.setWeightage(claimWeightage);
		
				dbStatus = cad.saveClaim(claimPolicyID,caBean);
			
			if (!dbStatus.equals(null)) {
				HttpSession session1 = request.getSession();
				session1.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("claimSuccessful.jsp");
		}
	}
		String btnClaim2 = request.getParameter("btnClaim2");
		if(btnClaim2!=null){
		ctBean.setPolicyID(claimPolicyID);
		ctBean.setVehcileFirstName(ctFirstName);
		ctBean.setVehcileLastName(ctLastName);
		ctBean.setVehicleClaim(ctClaim);
		ctBean.setVehicleClaimDate(ctClaimDate);
		ctBean.setDateOfTheft(claimDateOfTheft);
		ctBean.setDateOfComplaint(claimDateOfComplaint);
		ctBean.setFirNo(claimFIRNo);
		ctBean.setPsBranch(claimPSBranch);
		
		dbStatus = cad.saveClaim2(claimPolicyID,ctBean);
		
		if (!dbStatus.equals(null)) {
			HttpSession session1 = request.getSession();
			session1.setAttribute("dbStatus", dbStatus);
			response.sendRedirect("claimSuccessful.jsp");
	}
		}

	}
}
