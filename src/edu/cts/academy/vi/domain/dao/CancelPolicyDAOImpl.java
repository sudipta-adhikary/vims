package edu.cts.academy.vi.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.CancelPolicyForm;

public class CancelPolicyDAOImpl implements CancelPolicyDAO{
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String dbStatus;
	public List<VehicleRegistrationForm> displayVehicle(String cancelPolicyID) {
		con = ConnectionFactory.getInstance().getConnection();
		List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
		
		try {
			
			ps = con.prepareStatement("select * from vehicle_registration where policyID = ?");
			ps.setString(1, cancelPolicyID);
			rs = ps.executeQuery();
			while (rs.next()) {
				VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
				vuBean.setPolicyID(rs.getString(1));
				vuBean.setVehicleFirstName(rs.getString(2));
				vuBean.setVehicleLastName(rs.getString(3));
				vuBean.setVehicleState(rs.getString(4));
				vuBean.setVehicleClass(rs.getString(5));
				vuBean.setVehicleType(rs.getString(6));
				vuBean.setVehicleManufacturer(rs.getString(7));
				vuBean.setVehicleModel(rs.getString(8));
				vuBean.setVehicleEngineNo(rs.getString(9));
				vuBean.setVehicleYear(rs.getString(10));
				vuBean.setVehicleLocation(rs.getString(11));
				vuBean.setVehiclePrice(rs.getString(12));
				vuBean.setVehicleDOP(rs.getString(13));
				vuBean.setVehiclePremium(rs.getString(14));
				vuBean.setVehiclePremiumDate(rs.getString(15));
				vuBean.setVehicleClaim(rs.getString(16));
				vuBean.setVehicleClaimDate(rs.getString(17));
				vList.add(vuBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vList;
	}
	public String savePolicy(String cancelPolicyID, CancelPolicyForm cpBean) {
		try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			System.out.println(cancelPolicyID);
			String sql = "insert into cancel_policy(policyID, cancelPolicyDate) values (?, ?) ";
			ps = con.prepareStatement(sql);
			int cancelPolicyID1 = Integer.parseInt(cancelPolicyID);
			ps.setInt(1, cancelPolicyID1);
			ps.setString(2, cpBean.getCancelPolicyDate());
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
	public String deletePolicy(String policyId) {
		con = ConnectionFactory.getInstance().getConnection();
		try {
			ps = con.prepareStatement("delete from vehicle_registration where policyID = ?");
			ps.setString(1, policyId);
			int row = ps.executeUpdate();
			if (row > 0) {
				dbStatus = "Delete Successful!";
			} else {
				dbStatus = "Delete Failed!";
			}
			System.out.println(dbStatus);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dbStatus;
	}

}
