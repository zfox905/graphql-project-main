package com.graphql.learn.repositories;

import com.graphql.learn.entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckoutRep extends JpaRepository<Checkout, Integer> {
}
