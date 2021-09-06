package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.PaginatedStudentResponse;
import com.spring.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/student/search")
	public ResponseEntity<PaginatedStudentResponse> readStudent(Pageable pageable) {
		return ResponseEntity.ok(studentService.readStudent(pageable));
	}
	
	@GetMapping("/book/search/filter")
    public ResponseEntity<PaginatedStudentResponse> readBooksWithFilter (@RequestParam("query") String query, Pageable pageable) {
        return ResponseEntity.ok(studentService.filterStudents(query, pageable));
    }
}
