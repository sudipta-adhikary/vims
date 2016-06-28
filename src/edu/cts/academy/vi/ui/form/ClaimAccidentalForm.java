package edu.cts.academy.vi.ui.form;

public class ClaimAccidentalForm {

		private String claimID;
		private String policyID;
		private String vehcileFirstName;
		private String vehcileLastName;
		private String vehicleClaim;
		private String vehicleClaimDate;
		
		public String getVehicleClaim() {
			return vehicleClaim;
		}

		public void setVehicleClaim(String vehicleCLaim) {
			this.vehicleClaim = vehicleCLaim;
		}

		public String getVehicleClaimDate() {
			return vehicleClaimDate;
		}

		public void setVehicleClaimDate(String vehicleClaimDate) {
			this.vehicleClaimDate = vehicleClaimDate;
		}

		private String accidentType;
		private String weightage;
		
		public ClaimAccidentalForm(){
			
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

		

		public String getAccidentType() {
			return accidentType;
		}

		public void setAccidentType(String accidentType) {
			this.accidentType = accidentType;
		}

		public String getWeightage() {
			return weightage;
		}

		public void setWeightage(String weightage) {
			this.weightage = weightage;
		}
		
		
}
