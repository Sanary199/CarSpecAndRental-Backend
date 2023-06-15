package com.carrental.models;

import org.springframework.web.multipart.MultipartFile;

import com.carrental.entities.Company;

public class SpecVariantsDTO {
	private String title;
	private int price;
	private Company company;
	private MultipartFile photo;
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public MultipartFile getPhoto() {
		return photo;
	}
	public void setPhoto(MultipartFile photo) {
		this.photo = photo;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "SpecVariantsDTO [title=" + title + ", price=" + price + ", company=" + company + ", photo=" + photo
				+ "]";
	}

}
