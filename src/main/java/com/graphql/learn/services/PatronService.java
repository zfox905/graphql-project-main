package com.graphql.learn.services;

import com.graphql.learn.entities.PatronAccount;

import java.util.List;

public interface PatronService {

    PatronAccount create(PatronAccount patronAccount);

    //get all
    List<PatronAccount> getAll();

    //get single book
    PatronAccount get(int patronAccountId);
}
