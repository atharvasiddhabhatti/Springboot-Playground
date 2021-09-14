package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.entity.Student;
import com.spring.repository.StudentRepository;
import com.spring.service.StudentService;

@SpringBootApplication
public class SpringbootDemoPaginationSortingFilteringApplication implements Runnable {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoPaginationSortingFilteringApplication.class, args);
	}

	@Override
	public void run() {
	Student student1 = new Student(1,"Atharva",22);
	Student student2 = new Student(2,"Raj",21);
	studentRepository.save(student1);
	studentRepository.save(student2);
	
		
	}

}
