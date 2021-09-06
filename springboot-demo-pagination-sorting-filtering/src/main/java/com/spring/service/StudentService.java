package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.spring.entity.PaginatedStudentResponse;
import com.spring.entity.Student;
import com.spring.repository.StudentRepository;

public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	public PaginatedStudentResponse readStudent(Pageable pageable) {
		Page<Student> students = studentRepository.findAll(pageable);
		return PaginatedStudentResponse.builder()
				.numberOfItems(students.getTotalElements()).numberOfPages(students.getTotalPages())
				.studentList(students.getContent())
				.build();
				
	}
	
	public PaginatedStudentResponse filterStudents(String name, Pageable pageable) {
		Page<Student> students = studentRepository.findAllByNameContaints(name, pageable);
		return PaginatedStudentResponse.builder()
				.numberOfItems(students.getTotalElements()).numberOfPages(students.getTotalPages())
                .studentList(students.getContent())
                .build();
	}
}
