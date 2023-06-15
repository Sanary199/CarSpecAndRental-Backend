package com.carrental.models;

public class CarSpecDTO {
	private String id;
	private String modelname;
	private int svarid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModelname() {
		return modelname;
	}
	public void setModelname(String modelname) {
		this.modelname = modelname;
	}
	public int getVarid() {
		return svarid;
	}
	public void setVarid(int svarid) {
		this.svarid = svarid;
	}
	
	
	@Override
	public String toString() {
		return "CarSpecDTO [id=" + id + ", modelname=" + modelname + ", svarid=" + svarid + "]";
	}
}
