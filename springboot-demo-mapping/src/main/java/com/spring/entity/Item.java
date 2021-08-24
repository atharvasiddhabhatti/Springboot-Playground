package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Item {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	public Item(String name) {
		super();
		this.name = name;
	}
	
//	@OneToOne(cascade = CascadeType.ALL,mappedBy = "item")
//	private Customer customer;
//	
	
	
}
