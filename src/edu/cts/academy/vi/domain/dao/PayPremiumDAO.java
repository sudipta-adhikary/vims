package edu.cts.academy.vi.domain.dao;

import java.util.List;

import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.PayDirectForm;
import edu.cts.academy.vi.ui.form.PayRegisteredForm;


public interface PayPremiumDAO {
	public String savePayDirect(String pPolicyID, PayDirectForm ppBean);
	public List<VehicleRegistrationForm> displayVehicle(String payPolicyID);
	public String savePayRegistered(String payPolicyID, PayRegisteredForm pdBean);
}
