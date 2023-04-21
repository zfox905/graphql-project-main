package com.graphql.learn.services.impl;

import com.graphql.learn.entities.Author;
import com.graphql.learn.repositories.AuthorRep;
import com.graphql.learn.repositories.BookRep;
import com.graphql.learn.services.AuthorService;
import com.graphql.learn.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {


    private AuthorRep authorRep;

    @Autowired
    public AuthorServiceImpl(AuthorRep authorRep) {
        this.authorRep = authorRep;
    }

    @Override
    public Author create(Author author) {
        return this.authorRep.save(author);
    }

    @Override
    public List<Author> getAll() {
        return this.authorRep.findAll();
    }

    @Override
    public Author get(int authorId) {
        return this.authorRep.findById(authorId).orElseThrow(() -> new RuntimeException("Book you are looking for not found on server !!"));
    }
}

