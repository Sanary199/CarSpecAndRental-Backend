package com.carrental.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SpecVariants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int price;
	private int onroadprice;
	
	private String photo;
	@ManyToOne
	@JoinColumn(name="company_id")
	private Company company;
	private LocalDateTime createdon;
	public SpecVariants() {
		this.createdon=LocalDateTime.now();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public LocalDateTime getCreatedon() {
		return createdon;
	}
	public void setCreatedon(LocalDateTime createdon) {
		this.createdon = createdon;
	}
	public int getOnroadprice() {
		return onroadprice;
	}

	public void setOnroadprice(int onroadprice) {
		this.onroadprice = onroadprice;
	}
	@Override
	public String toString() {
		return "SpecVariants [id=" + id + ", title=" + title + ", price=" + price + ", onroadprice=" + onroadprice
				+ ", photo=" + photo + ", company=" + company + ", createdon=" + createdon + "]";
	}
}
