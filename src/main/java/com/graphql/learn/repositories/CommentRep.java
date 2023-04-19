package com.graphql.learn.repositories;

import com.graphql.learn.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRep extends JpaRepository<Comment, Integer> {
}
