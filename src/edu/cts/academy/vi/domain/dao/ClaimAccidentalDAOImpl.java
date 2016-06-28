package edu.cts.academy.vi.domain.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.ClaimAccidentalForm;
import edu.cts.academy.vi.ui.form.ClaimTheftForm;

public class ClaimAccidentalDAOImpl implements ClaimAccidentalDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String dbStatus;
	

	public String saveClaim(String claimPolicyID, ClaimAccidentalForm caBean) {
		
	try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			System.out.println(claimPolicyID);
			String sql = "insert into claim_accidental(policyID, vehicleFirstName, vehicleLastName, vehicleClaim, vehicleClaimDate, accidentType, weightage) values (?, ?, ?, ?, ?, ?, ?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, claimPolicyID);
			ps.setString(2, caBean.getVehcileFirstName());
			ps.setString(3, caBean.getVehcileLastName());
			ps.setString(4, caBean.getVehicleClaim());
			ps.setString(5, caBean.getVehicleClaimDate());
			ps.setString(6, caBean.getAccidentType());
			ps.setString(7, caBean.getWeightage());
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


	public List<VehicleRegistrationForm> displayVehicle(String claimPolicyID) {
		con = ConnectionFactory.getInstance().getConnection();
		List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
		
		try {
			
			ps = con.prepareStatement("select policyID, vehicleFirstName, vehicleLastName, vehicleClaim, vehicleClaimDate from vehicle_registration where policyID = ?");
			ps.setString(1, claimPolicyID);
			rs = ps.executeQuery();
			while (rs.next()) {
				
				VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
				
				vuBean.setPolicyID(rs.getString(1));
				vuBean.setVehicleFirstName(rs.getString(2)); System.out.println(rs.getString(2));
				vuBean.setVehicleLastName(rs.getString(3));
				vuBean.setVehicleClaim(rs.getString(4));
				vuBean.setVehicleClaimDate(rs.getString(5));
				vList.add(vuBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vList;
	}


	public String saveClaim2(String claimPolicyID, ClaimTheftForm ctBean) {
		try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			System.out.println(claimPolicyID);
			String sql = "insert into claim_theft(policyID, vehicleFirstName, vehicleLastName, vehicleClaim, vehicleClaimDate, dateOfTheft, dateOfComplaint, firNo, psBranch) values (?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			ps = con.prepareStatement(sql);
			ps.setString(1, claimPolicyID);
			ps.setString(2, ctBean.getVehcileFirstName());
			ps.setString(3, ctBean.getVehcileLastName());
			ps.setString(4, ctBean.getVehicleClaim());
			ps.setString(5, ctBean.getVehicleClaimDate());
			ps.setString(6, ctBean.getDateOfTheft());
			ps.setString(7, ctBean.getDateOfComplaint());
			ps.setString(8, ctBean.getFirNo());
			ps.setString(9, ctBean.getPsBranch());
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
	
	

