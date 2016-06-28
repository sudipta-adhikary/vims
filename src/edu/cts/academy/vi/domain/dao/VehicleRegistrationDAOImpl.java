package edu.cts.academy.vi.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;

public class VehicleRegistrationDAOImpl implements VehicleRegistrationDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String dbStatus;
	
	

	public List<VehicleRegistrationForm> displayVehicle() {
		con = ConnectionFactory.getInstance().getConnection();
		List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
		try {
			ps = con.prepareStatement("select * from vehicle_registration");
			rs = ps.executeQuery();
			while (rs.next()) {
				
				VehicleRegistrationForm vuBean = new VehicleRegistrationForm();
				
				vuBean.setPolicyID(rs.getString(1));
				vuBean.setVehicleFirstName(rs.getString(2)); System.out.println(rs.getString(2));
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
				vList.add(vuBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vList;
	}


	public List<VehicleRegistrationForm> deletePolicy(String policyID) {
		con = ConnectionFactory.getInstance().getConnection();
		List<VehicleRegistrationForm> vList = new ArrayList<VehicleRegistrationForm>();
		try {
			ps = con.prepareStatement("delete from vehicle_registration where policyID = ?");
			ps.setString(1, policyID);
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
		vList=displayVehicle();
		return vList;
	}
	

	public String updateDeal(VehicleRegistrationForm vuBean) {
		try {
			con = (Connection) ConnectionFactory.getInstance().getConnection();
			String sql = "UPDATE vehicle_registration set vehicleFirstName=?, vehicleLastName=?, vehicleState=?, vehicleClass=?, vehicleType=?, vehicleManufacturer=?, vehicleModel=?, vehicleEngineNo=?, vehicleYear=?, vehicleLocation=?, vehiclePrice=?, vehicleDOP=? where policyID=?";
			ps = con.prepareStatement(sql);
			
			ps = con.prepareStatement(sql);
			ps.setString(13, vuBean.getPolicyID());
			ps.setString(1, vuBean.getVehicleFirstName());
			ps.setString(2, vuBean.getVehicleLastName());
			ps.setString(3, vuBean.getVehicleState());
			ps.setString(4, vuBean.getVehicleClass());
			ps.setString(5, vuBean.getVehicleType());
			ps.setString(6, vuBean.getVehicleManufacturer());
			ps.setString(7, vuBean.getVehicleModel());
			ps.setString(8, vuBean.getVehicleEngineNo());
			ps.setString(9, vuBean.getVehicleYear());
			ps.setString(10, vuBean.getVehicleLocation());
			ps.setString(11, vuBean.getVehiclePrice());
			ps.setString(12, vuBean.getVehicleDOP());
			
			int row = ps.executeUpdate();
			if (row > 0) {
				dbStatus = "Update Successful!";
			} else {
				dbStatus = "Update Failed!";
			}
		} catch (SQLException ex) {
			dbStatus = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		} catch (Exception ex) {
			dbStatus = "ERROR: " + ex.getMessage();
			ex.printStackTrace();
		}
		return dbStatus;
	
	}

}
