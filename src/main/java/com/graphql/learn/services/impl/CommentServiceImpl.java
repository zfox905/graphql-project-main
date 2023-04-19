package com.graphql.learn.services.impl;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.Comment;
import com.graphql.learn.repositories.BookRep;
import com.graphql.learn.repositories.CommentRep;
import com.graphql.learn.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRep commentRep;

    @Autowired
    public CommentServiceImpl(CommentRep commentRep) {
        this.commentRep = commentRep;
    }
    @Override
    public Comment create(Comment comment) {
        return this.commentRep.save(comment);
    }
    @Override
    public List<Comment> getAll() {
        return this.commentRep.findAll();
    }
}
