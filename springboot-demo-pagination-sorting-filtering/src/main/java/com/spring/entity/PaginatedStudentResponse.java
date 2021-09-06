package com.spring.entity;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaginatedStudentResponse {
	List<Student> studentList;
	private Long numberOfItems;
	private Integer numberOfPages;
	
}
