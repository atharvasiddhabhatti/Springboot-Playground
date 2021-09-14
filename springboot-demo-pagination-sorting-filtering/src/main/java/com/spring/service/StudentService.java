package com.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.entity.PaginatedStudentResponse;
import com.spring.entity.Student;
import com.spring.repository.StudentRepository;


@Service
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
	
	public List<Student> getAllStudents(Integer pageNo, Integer pageSize, String sortBy)
		{
			Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
			Page<Student> pageResult = studentRepository.findAll(paging);
			
			if(pageResult.hasContent()) {
				return pageResult.getContent();
			}
			else
			{
				return new ArrayList<Student>();
			}
		}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
}
