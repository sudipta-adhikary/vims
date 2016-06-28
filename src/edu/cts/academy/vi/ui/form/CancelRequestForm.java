package edu.cts.academy.vi.ui.form;

public class CancelRequestForm {
	private String policyID;
	public String getPolicyID() {
		return policyID;
	}
	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	private String reason;
	private String requestDate;

}
