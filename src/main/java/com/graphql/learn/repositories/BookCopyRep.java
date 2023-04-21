package com.graphql.learn.repositories;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.BookCopy;
import com.graphql.learn.entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookCopyRep extends JpaRepository<BookCopy, Integer> {

    List<BookCopy> findBookCopyByBook(Book b);

    @Query("SELECT bookCopy FROM BookCopy bookCopy WHERE bookCopy.id=?1 AND bookCopy.id NOT IN (SELECT bookCopy.id FROM Checkout WHERE isReturned=true)")
    BookCopy availableBooks(Integer id);

    @Query("SELECT bookCopy FROM BookCopy bookCopy WHERE bookCopy.id NOT IN (SELECT checkout.bookCopy.id FROM Checkout checkout WHERE checkout.isReturned=false)")
    List<BookCopy> availBooks();
}
