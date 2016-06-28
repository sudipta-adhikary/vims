package edu.cts.academy.vi.domain.dao;

import java.util.List;

import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;


public interface VehicleRegistrationDAO {
	
	/*public String registerVehicle(VehicleRegistrationBean vBean);*/
	
	public List<VehicleRegistrationForm> displayVehicle();

	/*public List<VehicleRegistrationBean> searchVehicle(String vehicleEngineNo);*/
	
	public List<VehicleRegistrationForm> deletePolicy(String policyId);
	
	public String updateDeal(VehicleRegistrationForm vBean);
}
