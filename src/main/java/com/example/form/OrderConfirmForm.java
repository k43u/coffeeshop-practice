package com.example.form;

public class OrderConfirmForm {

	private String destinationName;
	private String destinationEmail;
	private String destinationZipcode;
	private String destinationAddress;
	private String destinationTel;
	private String deliveryTime;
	private String paymentmethod;
	
	public String getDestinationName() {
		return destinationName;
	}
	public String getDestinationEmail() {
		return destinationEmail;
	}
	public String getDestinationZipcode() {
		return destinationZipcode;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public String getDestinationTel() {
		return destinationTel;
	}
	public String getDeliveryTime() {
		return deliveryTime;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public void setDestinationEmail(String destinationEmail) {
		this.destinationEmail = destinationEmail;
	}
	public void setDestinationZipcode(String destinationZipcode) {
		this.destinationZipcode = destinationZipcode;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	public void setDestinationTel(String destinationTel) {
		this.destinationTel = destinationTel;
	}
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	@Override
	public String toString() {
		return "OrderConfirmForm [destinationName=" + destinationName + ", destinationEmail=" + destinationEmail
				+ ", destinationZipcode=" + destinationZipcode + ", destinationAddress=" + destinationAddress
				+ ", destinationTel=" + destinationTel + ", deliveryTime=" + deliveryTime + ", paymentmethod="
				+ paymentmethod + "]";
	}
	
	
}
