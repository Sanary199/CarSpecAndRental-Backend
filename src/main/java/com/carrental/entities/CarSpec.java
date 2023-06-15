package com.carrental.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


@Entity
@DynamicUpdate
@DynamicInsert
public class CarSpec {
	@Id
	private String id;
	private String modelname;
	private int price;
	private int onroadprice;
	@ManyToOne
	@JoinColumn(name="specvariants_id")
	private SpecVariants specvariant;
	private boolean isdeleted;
	private LocalDateTime createdon;
	private String status;
	public CarSpec() {
		// TODO Auto-generated constructor stub
		this.createdon=LocalDateTime.now();
		this.isdeleted=false;
		this.status="Available";
	}
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getOnroadprice() {
		return onroadprice;
	}
	public void setOnroadprice(int onroadprice) {
		this.onroadprice = onroadprice;
	}
	public SpecVariants getVariant() {
		return specvariant;
	}
	public void setSpecVariants(SpecVariants specvariant) {
		this.specvariant = specvariant;
	}
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "CarSpec [id=" + id + ", modelname=" + modelname + ", price=" + price + ", onroadprice=" + onroadprice
				+ ", specvariant=" + specvariant + ", isdeleted=" + isdeleted + ", createdon=" + createdon + ", status="
				+ status + "]";
	}
	
		
}

