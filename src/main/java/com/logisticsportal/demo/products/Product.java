package com.logisticsportal.demo.products;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@Column(name="ProductID")
	int productID;
	@Column(name="ProductName")
	String productName;
	@Column(name="Description")
	String desc;
	@Column(name="Batch")
	int batchID;
	@Column(name="Category")
	String category;
	@Column(name="Manufacturer")
	String manufacturer;
	@Column(name="Weight")
	int weight;
	@Column(name="Dimensions")
	int dimensions;
	@Column(name="StorageConditions")
	String storageConditions;
	
	public Product(int productID, 	String productName,String desc) {
	 this.productID = productID;
	 this.productName = productName;
	 this.desc = desc;
	 this.batchID = batchID;
	 this.category = category;
	 this.manufacturer = manufacturer;
	 this.weight = weight;
	 this.dimensions = dimensions;
	 this.storageConditions = storageConditions;
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
	public int getBatchID() {
		return batchID;
	}
	public void setBatchID(int batchID) {
		this.batchID = batchID;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getDimensions() {
		return dimensions;
	}
	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
	public String getStorageConditions() {
		return storageConditions;
	}
	public void setStorageConditions(String storageConditions) {
		this.storageConditions = storageConditions;
	}
		
}
