package com.spring.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String city;
    @Column
    private String State;
    @Column
    private Integer zip;
    @Column
    private Integer regno;
    @Column
    private Integer propertyno;
    @Column
    private Float area;
    @Column
    private Integer surveyno;
    @Column
    private String type;
    @Column
    private String email;
    @Column
    private String status;
    @Column
    private String username;
}

