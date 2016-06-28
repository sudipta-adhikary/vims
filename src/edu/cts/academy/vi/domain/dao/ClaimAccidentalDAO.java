package edu.cts.academy.vi.domain.dao;

import java.util.List;

import edu.cts.academy.vi.ui.form.VehicleRegistrationForm;
import edu.cts.academy.vi.ui.form.ClaimAccidentalForm;
import edu.cts.academy.vi.ui.form.ClaimTheftForm;


public interface ClaimAccidentalDAO {
	public String saveClaim(String claimPolicyID, ClaimAccidentalForm caBean);
	public List<VehicleRegistrationForm> displayVehicle(String claimPolicyID);
	public String saveClaim2(String claimPolicyID, ClaimTheftForm ctBean);
}
