package edu.cts.academy.vi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cts.academy.vi.domain.dao.UserSignUpDAOImpl;
import edu.cts.academy.vi.ui.form.UserSignUpForm;

@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	UserSignUpForm cBean=new UserSignUpForm();
	UserSignUpDAOImpl cd=new UserSignUpDAOImpl();
	String dbStatus;
   
	public SignUpController(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String btnSignUp=request.getParameter("btnSignUp");
		String btnSignIn=request.getParameter("btnSignIn");
		HttpSession session = request.getSession(true);
		int d=0;
		
		if(btnSignUp != null){
		
			cBean.setUserFirstName(request.getParameter("firstName"));
			cBean.setUserFirstName(request.getParameter("lastName"));
			cBean.setUserGender(request.getParameter("gender"));
			cBean.setUserDOB(request.getParameter("dob"));
			cBean.setUserContactNo(request.getParameter("contactno"));
			cBean.setUserAddress(request.getParameter("address"));
			cBean.setUserCountry(request.getParameter("country"));
			cBean.setUserState(request.getParameter("state"));
			cBean.setUserCity(request.getParameter("city"));
			cBean.setUserPincode(request.getParameter("pin"));
			cBean.setUserEmail(request.getParameter("email"));
			cBean.setUserPassword(request.getParameter("password"));
			System.out.println(request.getParameter("password"));
			System.out.println(request.getParameter("lastName"));
			if(cBean.getUserPassword().equals(request.getParameter("password1"))){
				
				dbStatus=cd.saveSignUp(cBean);
				
				request.setAttribute("dbStatus", dbStatus);
				RequestDispatcher rd = request.getRequestDispatcher("registrationSuccessful.jsp");
				rd.forward(request, response);
			}
			else{
				request.setAttribute("dbStatus", "Password not matching...!");
				RequestDispatcher rd = request.getRequestDispatcher("signUpForm.jsp");
				rd.forward(request, response);
			}	
		}
			/*else if (btnSignIn != null) {
				try {
					cBean.setUserEmail(request.getParameter("userName"));
					cBean.setUserPassword(request.getParameter("password"));
					
					

					cBean = cd.login(cBean);
					
					System.out.println(cBean.isValid());
					if (cBean.isValid()){
						
						session.setAttribute("loggedUser", cBean);
						if(request.getParameter("userName")=="VIM"  && request.getParameter("password")=="admin")
						{
							request.getRequestDispatcher("adminHome.jsp").forward(request, response);
						}
						else
						{
							request.getRequestDispatcher("userHome.jsp").forward(request, response);
						}
						//request.getRequestDispatcher("adminHome.jsp").forward(request, response);
						/*else
							request.getRequestDispatcher("payPremium.jsp").forward(request, response);*/
					//}
					//else {
						/*String VIM = new String("VIM");
						String admin = new String("admin");*/
						//if(request.getParameter("userName")=="VIM"  && request.getParameter("password")=="admin")
						/*if(cBean.getUserEmail().equals("VIM") && cBean.getUserPassword().equals("admin"))
						{
							request.getRequestDispatcher("adminHome.jsp").forward(request, response);
						}
						//request.getRequestDispatcher("vehicleRegistrationForm.jsp").forward(request, response);
						else
							//request.getRequestDispatcher("payPremiumForm.jsp").forward(request, response);
						response.sendRedirect("userHome.jsp");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		}*/
		else if (btnSignIn != null) {
            try {
                cBean.setUserEmail(request.getParameter("userName"));
                cBean.setUserPassword(request.getParameter("password"));
                
                

                d = cd.clogin(cBean);
                
                //System.out.println(cBean.isValid());
               // if (cBean.isValid()){
                    //HttpSession session = request.getSession(true);
                   // session.setAttribute("loggedUser", cBean);
                    /*if(request.getParameter("userName")=="VIM"  && request.getParameter("password")=="admin")
                    {
                        request.getRequestDispatcher("vehicleRegistrationForm.jsp").forward(request, response);
                    }*/
                   // request.getRequestDispatcher("vehicleRegistrationForm.jsp").forward(request, response);
                    /*else
                        request.getRequestDispatcher("payPremium.jsp").forward(request, response);*/
               // }
                //else {
                    /*String VIM = new String("VIM");
                    String admin = new String("admin");*/
                    //if(request.getParameter("userName")=="VIM"  && request.getParameter("password")=="admin")
                    if(cBean.getUserEmail().equals("VIM") && cBean.getUserPassword().equals("admin"))
                    {
                        request.getRequestDispatcher("adminHome.jsp").forward(request, response);
                    }
                    //request.getRequestDispatcher("vehicleRegistrationForm.jsp").forward(request, response);
                    else if(d==1)
                        //request.getRequestDispatcher("payPremiumForm.jsp").forward(request, response);
                    response.sendRedirect("userHome.jsp");
                    else
                    {
                    	response.sendRedirect("loginFailed.jsp");
                		
                    }
                }
            catch (Exception e) {
                e.printStackTrace();
            }
    }
		String password = request.getParameter("password");
		session.setAttribute("password", password);
		
		String btnLogin=request.getParameter("btnLogin");
		if (btnLogin!=null){
			try {
				cBean.setUserEmail(request.getParameter("userName"));
				cBean.setUserPassword(password);
				
				

				cBean = cd.login(cBean);
				
				System.out.println(cBean.isValid());
				if (cBean.isValid()){
					
					session.setAttribute("loggedUser", cBean);
					request.getRequestDispatcher("payRegistered.jsp").forward(request, response);
			}
				else
					{response.sendRedirect("payRegistered.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
}
	

