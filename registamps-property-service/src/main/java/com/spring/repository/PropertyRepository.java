package com.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
	List<Property> findByStatus(String status);
}
