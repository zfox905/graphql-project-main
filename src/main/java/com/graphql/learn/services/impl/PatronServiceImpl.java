package com.graphql.learn.services.impl;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.Comment;
import com.graphql.learn.entities.PatronAccount;
import com.graphql.learn.repositories.CommentRep;
import com.graphql.learn.repositories.PatronRep;
import com.graphql.learn.services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatronServiceImpl implements PatronService {

    private PatronRep patronRep;

    @Autowired
    public PatronServiceImpl(PatronRep patronRep) {
        this.patronRep = patronRep;
    }
    @Override
    public PatronAccount create(PatronAccount patronAccount) {
        return this.patronRep.save(patronAccount);
    }
    @Override
    public List<PatronAccount> getAll() {
        return this.patronRep.findAll();
    }
    @Override
    public PatronAccount get(int patronAccountId) {
        return this.patronRep.findById(patronAccountId).orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
    }
}
