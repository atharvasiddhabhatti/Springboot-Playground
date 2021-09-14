package com.spring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Student;

@Repository
public interface SortingRepository extends PagingAndSortingRepository<Student, Integer>  {

}
