package edu.cts.academy.vi.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.PayDirectForm;
import edu.cts.academy.vi.ui.form.PayRegisteredForm;

public class PayPremiumDAOImpl implements PayPremiumDAO{
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String dbStatus;


	public List<VehicleRegistrationForm> displayVehicle(String payPolicyID) {
		con = ConnectionFactory.getInstance().getConnection();
		List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
		
		System.out.println("red");
		try {
			
			ps = con.prepareStatement("select policyID, vehicleState, vehicleType, vehicleModel, vehiclePremium, vehiclePremiumDate from vehicle_registration where policyID = ?");
			ps.setString(1, payPolicyID);
			System.out.println(payPolicyID);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("blue");
				VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
				
				vuBean.setPolicyID(rs.getString(1));
				vuBean.setVehicleState(rs.getString(2)); System.out.println(rs.getString(2));
				vuBean.setVehicleType(rs.getString(3));
				vuBean.setVehicleModel(rs.getString(4));
				vuBean.setVehiclePremium(rs.getString(5));
				vuBean.setVehiclePremiumDate(rs.getString(6));
				vList.add(vuBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vList;
	}


	public String savePayRegistered(String payPolicyID, PayRegisteredForm pdBean) {
		try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			System.out.println(payPolicyID);
			String sql = "insert into pay_registered(policyID, policyState, policyVehicleType, policyVehicleModel, payPremium, payPremiumDate, paymentMode, payConatctNo) values (?, ?, ?, ?, ?, ?, ?, ?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, payPolicyID);
			ps.setString(2, pdBean.getVehicleState());
			ps.setString(3, pdBean.getPolicyVehicleType());
			ps.setString(4, pdBean.getPolicyVehicleModel());
			ps.setString(5, pdBean.getPayPremium());
			ps.setString(6, pdBean.getPayPremiumDate());
			ps.setString(7, pdBean.getPaymentMode());
			ps.setString(8, pdBean.getPayContactNo());
			int row = ps.executeUpdate();
			if (row > 0) {
				dbStatus = "Save Successful!";
			} else {
				dbStatus = "Save Failed!";
			}
		} catch (SQLException ex) {
			dbStatus = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		} catch (Exception ex) {
			dbStatus = "ERROR Message: " + ex.getMessage();
			ex.printStackTrace();
		}
		return dbStatus;
	}


	public String savePayDirect(String pPolicyID, PayDirectForm ppBean) {
		try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			System.out.println(pPolicyID);
			String sql = "insert into pay_direct(policyID, policyPremium, policyPremiumDate, policyPaymentMode, policyContactNo) values (?, ?, ?, ?, ?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, pPolicyID);
			ps.setString(2, ppBean.getPolicyPremium());
			ps.setString(3, ppBean.getPolicyPremiumDate());
			ps.setString(4, ppBean.getPaymentMode());
			ps.setString(5, ppBean.getContactNo());
			int row = ps.executeUpdate();
			if (row > 0) {
				dbStatus = "Save Successful!";
			} else {
				dbStatus = "Save Failed!";
			}
		} catch (SQLException ex) {
			dbStatus = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		} catch (Exception ex) {
			dbStatus = "ERROR Message: " + ex.getMessage();
			ex.printStackTrace();
		}
		return dbStatus;
	}
}
