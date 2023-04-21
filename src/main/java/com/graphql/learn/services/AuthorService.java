package com.graphql.learn.services;

import com.graphql.learn.entities.Author;


import java.util.List;

public interface AuthorService {

    Author create(Author book);

    //get all
    List<Author> getAll();

    //get single book
    Author get(int authorId);
}
