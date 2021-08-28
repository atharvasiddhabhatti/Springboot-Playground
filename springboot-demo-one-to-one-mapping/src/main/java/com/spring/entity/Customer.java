package com.spring.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "customer_details")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "customer_name")
	private String name;
	@Column(name = "customer_email")
	private String email;

	
	@OneToOne(fetch =FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private Item item;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}

	public Customer(String name, String email, Item item) {
		this.name = name;
		this.email = email;
		this.item = item;
	}
	public Customer() {
		super();
	}		
}
