package com.graphql.learn;

import com.graphql.learn.entities.Book;
import com.graphql.learn.entities.Comment;
import com.graphql.learn.services.BookService;
import com.graphql.learn.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentService commentService;

    public static void main(String[] args) {
        SpringApplication.run(GraphqlProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book();
        b1.setTitle("Complete Reference");
        b1.setDesc("For learning java");
        b1.setPages(2000);
        b1.setPrice(5000);
        b1.setAuthor("XYZ");

        Comment c = new Comment();
        c.setBook(b1);
        c.setComment("dobra knjiga");


        Book b2 = new Book();
        b2.setTitle("Think Java");
        b2.setDesc("For learning java");
        b2.setPages(3000);
        b2.setPrice(5000);
        b2.setAuthor("ABC");


        Book b3 = new Book();
        b3.setTitle("Head first to java");
        b3.setDesc("For starting java concepts");
        b3.setPages(1000);
        b3.setPrice(2000);
        b3.setAuthor("PQR");

        this.bookService.create(b1);
        this.bookService.create(b2);
        this.bookService.create(b3);

        this.commentService.create(c);


    }
}
