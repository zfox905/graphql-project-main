package com.graphql.learn.controllers;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.Comment;
import com.graphql.learn.services.BookService;
import com.graphql.learn.services.CommentService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentService commentService;


    //create



    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b=new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

    @MutationMapping("createComment")
    public Comment createComment(@Argument int book, @Argument CommentInput comment) {

        System.out.println("XXX: " + book);
        Book b = this.bookService.get(book);
        Comment c = new Comment();
        c.setComment(comment.getComment());
        c.setBook(b);
        return this.commentService.create(c);


    }

    //get all

    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

    @QueryMapping("allComments")
    public List<Comment> getAllComments() {
        return this.commentService.getAll();
    }

    //get single book
    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }

}

@Getter
@Setter
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}

@Getter
@Setter
class CommentInput{
    private String comment;
}

