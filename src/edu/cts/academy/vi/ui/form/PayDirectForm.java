package edu.cts.academy.vi.ui.form;

public class PayDirectForm {
	private String paymentID;
	private String policyID;
	private String policyPremium;
	private String policyPremiumDate;
	private String paymentMode;
	private String contactNo;
	
	public PayDirectForm(){
		
	}

	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public String getPolicyID() {
		return policyID;
	}

	public void setPolicyID(String policyID) {
		this.policyID = policyID;
	}

	public String getPolicyPremium() {
		return policyPremium;
	}

	public void setPolicyPremium(String policyPremium) {
		this.policyPremium = policyPremium;
	}

	public String getPolicyPremiumDate() {
		return policyPremiumDate;
	}

	public void setPolicyPremiumDate(String policyPremiumDate) {
		this.policyPremiumDate = policyPremiumDate;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
}
