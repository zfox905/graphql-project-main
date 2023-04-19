package com.graphql.learn.services;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.Comment;

import java.util.List;

public interface CommentService {

    Comment create(Comment comment);

    List<Comment> getAll();

    //get all

}
