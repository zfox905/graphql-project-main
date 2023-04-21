package com.graphql.learn.repositories;

import com.graphql.learn.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRep extends JpaRepository<Author, Integer> {
}
