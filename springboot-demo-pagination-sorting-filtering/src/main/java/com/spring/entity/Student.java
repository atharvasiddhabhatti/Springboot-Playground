package com.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	private Integer id;
	
	private String name;
	private Integer rollno;
}
