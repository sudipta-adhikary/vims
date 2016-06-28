package edu.cts.academy.vi.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.UserSignUpForm;

public class UserSignUpDAOImpl implements UserSignUpDAO {
	Connection con;
	PreparedStatement pst;
	Statement stmt;
	ResultSet rs;
	
	String dbStatus;


	public String saveSignUp(UserSignUpForm usBean) {
		try{
			con=ConnectionFactory.getInstance().getConnection();
			
			pst=con.prepareStatement("insert into customer_registration(userFirstName, userLastName, userGender, userDOB, userContactNo, userAddress, userCountry, userState, userCity, userPincode, userEmail, userPassword) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			pst.setString(1, usBean.getUserFirstName());
			pst.setString(2, usBean.getUserLastName());
			pst.setString(3, usBean.getUserGender());
			pst.setString(4, usBean.getUserDOB());
			pst.setString(5, usBean.getUserContactNo());
			pst.setString(6, usBean.getUserAddress());
			pst.setString(7, usBean.getUserCountry());
			pst.setString(8, usBean.getUserState());
			pst.setString(9, usBean.getUserCity());
			pst.setString(10, usBean.getUserPincode());
			pst.setString(11, usBean.getUserEmail());
			pst.setString(12, usBean.getUserPassword());
			System.out.println(usBean.getUserCity());
			int row=pst.executeUpdate();
			if(row>0){
				dbStatus="Save Successful!";
				
			}else {
				dbStatus="Save Failed!";
			}
	   System.out.println(dbStatus);
		}
		catch(Exception e){
		dbStatus="Error: "+ e.getMessage();
		}
			
		
		return dbStatus;
		
	}


	

	public UserSignUpForm login(UserSignUpForm usBean) {
		
		try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			stmt = con.createStatement();
			String searchQuery = "select userFirstName, userLastName, userEmail, userPassword from customer_registration where userEmail= '" + usBean.getUserEmail() + "' and userPassword= '" + usBean.getUserPassword() + "' ";
			System.out.println(usBean.getUserEmail());
			System.out.println(usBean.getUserPassword());
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();
			
			System.out.println("more:"+more);

			if (!more) {
				usBean.setValid(false);
			} else if (more) {
				usBean.setUserFirstName(rs.getString("userFirstName"));
				usBean.setUserFirstName(rs.getString("userLastName"));
				usBean.setValid(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return usBean;

	}
	public int clogin(UserSignUpForm cBean) {
		String s=null;
		int a=0;
	        
	        try {
	            con = (Connection) ConnectionFactory.getInstance().getConnection();
	            stmt = con.createStatement();
	            String searchQuery = "select userPassword from customer_registration where userEmail= '" + cBean.getUserEmail() + "'";
	            rs = stmt.executeQuery(searchQuery);
	            while(rs.next())
	            {
	            	s=rs.getString(1);
	            }
	            if(s.equals(cBean.getUserPassword()))
	            		{
	            		a=1;

	            		}
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	return a;
	       
	        

	    }
	}
