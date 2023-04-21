package com.graphql.learn;

import com.graphql.learn.entities.*;
import com.graphql.learn.repositories.BookCopyRep;
import com.graphql.learn.repositories.CheckoutRep;
import com.graphql.learn.repositories.PatronRep;
import com.graphql.learn.repositories.PublisherRep;
import com.graphql.learn.services.AuthorService;
import com.graphql.learn.services.BookService;
import com.graphql.learn.services.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class GraphqlProjectApplication implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCopyRep bookCopyRep;

    @Autowired
    private PublisherRep publisherRep;

    @Autowired
    private PatronRep patronRep;

    @Autowired
    private CheckoutRep checkoutRep;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AuthorService authorService;

    public static void main(String[] args) {
        SpringApplication.run(GraphqlProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Book b1 = new Book();
        b1.setTitle("XXX");
        b1.setDesc("For learning java");
        b1.setPages(2000);
        b1.setPrice(5000);
        b1.setAuthor("XYZ");

        Author a1 = new Author();
        a1.setName("Jack London");
        a1.setBooks(new HashSet<Book>(Arrays.asList(b1)));
        Author a2 = new Author();
        a2.setBooks(new HashSet<Book>(Arrays.asList(b1)));
        a2.setName("Mark Tven");
        Set<Author> authorSet = new HashSet<>();
        authorSet.add(a1);
        authorSet.add(a2);



        b1.setAuthors(authorSet);





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

        BookCopy bookCopy1 = new BookCopy();
        bookCopy1.setBook(b1);
        bookCopy1.setYearpublished(1979);
        Publisher publisher = new Publisher();
        publisher.setName("WROX");
        bookCopy1.setPublisher(publisher);

        BookCopy bookCopy2 = new BookCopy();
        BeanUtils.copyProperties(bookCopy1,bookCopy2);

        PatronAccount patronAccount = new PatronAccount();
        patronAccount.setCard_number("1");
        patronAccount.setFirstName("nemanja");

        Checkout checkout = new Checkout();
        checkout.setBookCopy(bookCopy1);
        checkout.setIsReturned(false);
        checkout.setPatronAccount(patronAccount);




        this.bookService.create(b1);
        this.bookService.create(b2);
        this.bookService.create(b3);

        this.commentService.create(c);

        this.authorService.create(a1);
        this.authorService.create(a2);

        this.publisherRep.save(publisher);

        this.bookCopyRep.save(bookCopy1);
        this.bookCopyRep.save(bookCopy2);

        this.patronRep.save(patronAccount);
        this.checkoutRep.save(checkout);





    }
}
