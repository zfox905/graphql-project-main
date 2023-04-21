package com.graphql.learn.repositories;

import com.graphql.learn.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRep extends JpaRepository<Book, Integer> {

    Book findBookByTitle(String bookName);
}
