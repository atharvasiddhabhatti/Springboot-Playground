package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
