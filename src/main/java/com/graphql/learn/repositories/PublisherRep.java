package com.graphql.learn.repositories;

import com.graphql.learn.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRep extends JpaRepository<Publisher, Integer> {
}
