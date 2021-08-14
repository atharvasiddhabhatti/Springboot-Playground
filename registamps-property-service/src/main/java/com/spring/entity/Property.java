package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String owner_name;
	private String city;
	private String state;
	private Integer zip ;
	private String address;
	private Integer survey_number ;
	private Integer aadharCardNumber;
	private String panCard;
	private String status;
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZip() {
		return zip;
	}
	public void setZip(Integer zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getSurvey_number() {
		return survey_number;
	}
	public void setSurvey_number(Integer survey_number) {
		this.survey_number = survey_number;
	}
	public Integer getAadharCardNumber() {
		return aadharCardNumber;
	}
	public void setAadharCardNumber(Integer aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Property(Integer id, String owner_name, String city, String state, Integer zip, String address,
			Integer survey_number, Integer aadharCardNumber, String panCard, String status) {
		super();
		this.id = id;
		this.owner_name = owner_name;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.address = address;
		this.survey_number = survey_number;
		this.aadharCardNumber = aadharCardNumber;
		this.panCard = panCard;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", owner_name=" + owner_name + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", address=" + address + ", survey_number=" + survey_number + ", aadharCardNumber="
				+ aadharCardNumber + ", panCard=" + panCard + ", status=" + status + "]";
	}
	
	
	
	 
	
}
