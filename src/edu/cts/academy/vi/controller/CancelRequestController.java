package edu.cts.academy.vi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cts.academy.vi.domain.dao.CancelRequestDAOImpl;
import edu.cts.academy.vi.ui.form.CancelRequestForm;

/**
 * Servlet implementation class CancelRequestController
 */
@WebServlet("/CancelRequestController")
public class CancelRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CancelRequestForm crf=new CancelRequestForm();
	CancelRequestDAOImpl crd=new CancelRequestDAOImpl();
	
       
   
    public CancelRequestController() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbStatus=null;
		HttpSession session=request.getSession();
		String submitButton=request.getParameter("submit");
		if(submitButton!=null)
		{
			crf.setPolicyID(request.getParameter("policyID"));
			crf.setReason(request.getParameter("reason"));
			crf.setRequestDate(request.getParameter("requestDate"));
			
			dbStatus=crd.cancleRequest(crf);
			if (!dbStatus.equals(null)) {
				
				session.setAttribute("dbStatus", dbStatus);
				response.sendRedirect("cancelDisplay.jsp");
			
		}
			
		}
		
	}

}
