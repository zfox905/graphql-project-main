package com.graphql.learn.repositories;

import com.graphql.learn.entities.PatronAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRep extends JpaRepository<PatronAccount, Integer> {
}
