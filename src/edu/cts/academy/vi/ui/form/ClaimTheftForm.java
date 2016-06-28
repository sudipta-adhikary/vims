package edu.cts.academy.vi.ui.form;

public class ClaimTheftForm {
	private String claimID;
	private String policyID;
	private String vehcileFirstName;
	private String vehcileLastName;
	private String vehicleClaim;
	private String vehicleClaimDate;
	
	public String getVehicleClaim() {
		return vehicleClaim;
	}

	public void setVehicleClaim(String vehicleClaim) {
		this.vehicleClaim = vehicleClaim;
	}

	public String getVehicleClaimDate() {
		return vehicleClaimDate;
	}

	public void setVehicleClaimDate(String vehicleClaimDate) {
		this.vehicleClaimDate = vehicleClaimDate;
	}

	private String dateOfTheft;
	private String dateOfComplaint;
	private String firNo;
	private String psBranch;
	
	public ClaimTheftForm(){
		
	}

	public String getClaimID() {
		return claimID;
	}

	public void setClaimID(String claimID) {
		this.claimID = claimID;
	}

	public String getPolicyID() {
		return policyID;
	}

	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	public String getVehcileFirstName() {
		return vehcileFirstName;
	}

	public void setVehcileFirstName(String vehcileFirstName) {
		this.vehcileFirstName = vehcileFirstName;
	}

	public String getVehcileLastName() {
		return vehcileLastName;
	}

	public void setVehcileLastName(String vehcileLastName) {
		this.vehcileLastName = vehcileLastName;
	}

	public String getDateOfTheft() {
		return dateOfTheft;
	}

	public void setDateOfTheft(String dateOfTheft) {
		this.dateOfTheft = dateOfTheft;
	}

	public String getDateOfComplaint() {
		return dateOfComplaint;
	}

	public void setDateOfComplaint(String dateOfComplaint) {
		this.dateOfComplaint = dateOfComplaint;
	}

	public String getFirNo() {
		return firNo;
	}

	public void setFirNo(String firNo) {
		this.firNo = firNo;
	}

	public String getPsBranch() {
		return psBranch;
	}

	public void setPsBranch(String psBranch) {
		this.psBranch = psBranch;
	}
	
}
