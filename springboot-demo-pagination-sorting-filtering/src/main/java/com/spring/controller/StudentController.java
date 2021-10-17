package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.PaginatedStudentResponse;
import com.spring.entity.Student;
import com.spring.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/student/search")
	public ResponseEntity<PaginatedStudentResponse> readStudent(Pageable pageable) {
		return ResponseEntity.ok(studentService.readStudent(pageable));
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> createProduct(@RequestBody Student student){
		return ResponseEntity.ok().body(this.studentService.createStudent(student));
	}
}

/*
 * http://localhost:8080/employees?pageSize=5
 * http://localhost:8080/employees?pageSize=5&pageNo=1
 * http://localhost:8080/employees?pageSize=5&pageNo=2
 * http://localhost:8080/employees?pageSize=5&pageNo=1&sortBy=email
 * http://localhost:8080/employees?pageSize=5&pageNo=1&sortBy=firstName
 */