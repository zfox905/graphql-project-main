package com.graphql.learn.entities;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private Set<BookCopy> bookCopy = new HashSet<>();
}
