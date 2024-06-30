package com.monocept.model;

import java.io.Serializable;

public class Supplier implements Serializable{
	private String supplierID;
	private String name;
	private long contactInformation;
	
	@Override
	public String toString() {
	    return "Supplier{" + "\n" +
	            "    supplierID=" + supplierID + ",\n" +
	            "    name='" + name + "',\n" +
	            "    contactInformation='" + contactInformation + "'\n" +
	            "}";
	}
	public Supplier(String supplierID, String name, long contactInformation) {
		super();
		this.supplierID = supplierID;
		this.name = name;
		this.contactInformation = contactInformation;
	}
	public Supplier() {
		super();
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactInformation() {
		return contactInformation;
	}
	public void setContactInformation(long contactInformation) {
		this.contactInformation = contactInformation;
	}
	
}
