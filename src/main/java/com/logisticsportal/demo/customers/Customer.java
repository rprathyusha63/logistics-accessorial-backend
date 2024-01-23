package com.logisticsportal.demo.customers;

public class Customer {
	int custID;
	String custFN;
	String custLN;
	
	public Customer(int custID, String custFN, String custLN) {
		this.custID=custID;
		this.custFN=custFN;
		this.custLN=custLN;
	}
	public int getCustID() {
		return custID;
	}
	public void setCustID(int custID) {
		this.custID = custID;
	}
	public String getCustFN() {
		return custFN;
	}
	public void setCustFN(String custFN) {
		this.custFN = custFN;
	}
	public String getCustLN() {
		return custLN;
	}
	public void setCustLN(String custLN) {
		this.custLN = custLN;
	}
	

//	String bn;
//	Boolean type;
//	String email;
//	long phN;
//	String addr;
//	String city;
//	String state;
//	String country;
//	String note;

}
