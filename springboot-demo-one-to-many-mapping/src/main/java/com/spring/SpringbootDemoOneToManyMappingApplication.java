package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.entity.Comment;
import com.spring.entity.Post;
import com.spring.repository.PostRepository;

@SpringBootApplication
public class SpringbootDemoOneToManyMappingApplication implements CommandLineRunner {
	
	@Autowired
	PostRepository postRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootDemoOneToManyMappingApplication.class, args);
		System.out.println("Application is Running");
	}

	@Override
	public void run(String... args) throws Exception {
		Post post = new Post("Spring Boot Post Title","Spring Boot Post Description");
		Comment comment1 = new Comment("Thanks for uploading");
		Comment comment2 = new Comment("Comment2 test");
		Comment comment3 = new Comment("Comment3 test");
		
		post.getComments().add(comment1);
		post.getComments().add(comment2);
		post.getComments().add(comment3);
		
		postRepository.save(post);
		
		
	}

}
