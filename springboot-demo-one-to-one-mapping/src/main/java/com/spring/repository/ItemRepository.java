package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
