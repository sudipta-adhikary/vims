package edu.cts.academy.vi.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.CancelRequestForm;

public class CancelRequestDAOImpl {
	private Connection con;
	private PreparedStatement ps;
	private String dbStatus;
	 public String cancleRequest(CancelRequestForm crBean)
	 {
		 con = ConnectionFactory.getInstance().getConnection();
		 try {
				
				ps = con.prepareStatement("insert into cancel_request(reason,request_date,policyID) values(?,?,?)");
				ps.setString(1, crBean.getReason());
				ps.setString(2, crBean.getRequestDate());
				ps.setString(3, crBean.getPolicyID());
				int row=ps.executeUpdate();
				if(row>0){
					dbStatus="Save Successful";
				}
				else
				{
					dbStatus="Save Failed";
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbStatus;
		}
	 }

