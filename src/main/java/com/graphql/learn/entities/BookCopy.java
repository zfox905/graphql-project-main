package com.graphql.learn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book_copy")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int yearpublished;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "book_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "publisher_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Publisher publisher;

    @OneToMany(mappedBy = "bookCopy", cascade = CascadeType.ALL)
    private Set<Checkout> checkouts = new HashSet<>();
}
