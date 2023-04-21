package com.graphql.learn.controllers;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.BookCopy;
import com.graphql.learn.repositories.BookCopyRep;
import com.graphql.learn.repositories.BookRep;
import com.graphql.learn.repositories.CheckoutRep;
import com.graphql.learn.services.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CheckoutController {
    private final CheckoutRep repository;

    private final BookCopyRep bookCopyRep;

    private final BookRep bookRep;


    private final BookServiceImpl bookService;

    CheckoutController(CheckoutRep repository, BookCopyRep bookCopyRep, BookRep bookRep, BookServiceImpl bookService) {
        this.repository = repository;
        this.bookCopyRep = bookCopyRep;
        this.bookRep = bookRep;
        this.bookService = bookService;
    }

    @GetMapping("/checkout/{name}")
    List<BookCopy> checkout(@PathVariable String name) {
        Book b = bookService.getByName(name);
        List<BookCopy> bookCopy = bookCopyRep.findBookCopyByBook(b);
        return bookCopy;


    }

    @GetMapping("/checkoutspecific/{id}")
    BookCopy checkoutSpecific(@PathVariable Integer id) {

        BookCopy bookCopy = bookCopyRep.availableBooks(id);
        return bookCopy;


    }

    @GetMapping("/available")
    List<BookCopy> availableBooks() {

        List<BookCopy> bookCopy = bookCopyRep.availBooks();
        return bookCopy;


    }

    @PostMapping("/newbook")
    Book newBook() {

        Book b = new Book();
        b.setTitle("ZZZZ");
        return bookRep.save(b);



    }
}
