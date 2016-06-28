package edu.cts.academy.vi.domain.dao;

import java.util.List;

import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.CancelPolicyForm;


public interface CancelPolicyDAO {
	public List<VehicleRegistrationForm> displayVehicle(String cancelPolicyID);
	public String savePolicy(String cancelPolicyID, CancelPolicyForm cpBean);
	public String deletePolicy(String policyId);
}
