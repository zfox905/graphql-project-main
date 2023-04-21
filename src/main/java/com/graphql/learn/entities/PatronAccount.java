package com.graphql.learn.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patron_account")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatronAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String card_number;

    private String firstName;

    private String lastName;

    private String email;

    private String status;

    @OneToMany(mappedBy = "patronAccount", cascade = CascadeType.ALL)
    private Set<Checkout> checkout = new HashSet<>();

}
