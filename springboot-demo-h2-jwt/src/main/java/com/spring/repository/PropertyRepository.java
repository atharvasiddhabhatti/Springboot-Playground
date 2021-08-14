package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

}
