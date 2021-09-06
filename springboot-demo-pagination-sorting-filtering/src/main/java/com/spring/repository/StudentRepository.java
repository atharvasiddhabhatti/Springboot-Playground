package com.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{
	Page<Student> findAllByNameContaints(String name, Pageable pageable);
}
