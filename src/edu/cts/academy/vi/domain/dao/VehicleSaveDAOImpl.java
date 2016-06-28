package edu.cts.academy.vi.domain.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.cts.academy.vi.domain.factory.ConnectionFactory;
import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;


public class VehicleSaveDAOImpl implements VehicleSaveDAO{

	
		private Connection con;
		private PreparedStatement ps;
		@SuppressWarnings("unused")
		private ResultSet rs;
		private String dbStatus;
		
	
		public String registerVehicle(VehicleRegistrationForm vuBean) {
			try {
				con = (Connection) ConnectionFactory.getInstance().getConnection();
				String sql = "insert into vehicle_registration(vehicleFirstName, vehicleLastName, vehicleState, vehicleClass, vehicleType, vehicleManufacturer, vehicleModel, vehicleEngineNo, vehicleYear, vehicleLocation, vehiclePrice, vehicleDOP, vehiclePremium, vehiclePremiumDate, vehicleClaim, vehicleClaimDate) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = con.prepareStatement(sql);
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
				ps.setString(13, vuBean.getVehiclePremium());
				ps.setString(14, vuBean.getVehiclePremiumDate());
				ps.setString(15, vuBean.getVehicleClaim());
				ps.setString(16, vuBean.getVehicleClaimDate());
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


