package com.logisticsportal.demo.entity;


public class Product {

	int productID;
	String productName;
	String desc;
//	int batchID;
//	String category;
//	String manufacturer;
//	int weight;
//	int dimensions;
//	String storageConditions;
	
	public Product(int productID, 	String productName,String desc) {
	 this.productID = productID;
	 this.productName = productName;
	 this.desc = desc;
//	 this.batchID = batchID;
//	 this.category = category;
//	 this.manufacturer = manufacturer;
	}
		
		
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
//	public int getBatchID() {
//		return batchID;
//	}
//	public void setBatchID(int batchID) {
//		this.batchID = batchID;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public String getManufacturer() {
//		return manufacturer;
//	}
//	public void setManufacturer(String manufacturer) {
//		this.manufacturer = manufacturer;
//	}
//	public int getWeight() {
//		return weight;
//	}
//	public void setWeight(int weight) {
//		this.weight = weight;
//	}
//	public int getDimensions() {
//		return dimensions;
//	}
//	public void setDimensions(int dimensions) {
//		this.dimensions = dimensions;
//	}
//	public String getStorageConditions() {
//		return storageConditions;
//	}
//	public void setStorageConditions(String storageConditions) {
//		this.storageConditions = storageConditions;
//	}
		
}
