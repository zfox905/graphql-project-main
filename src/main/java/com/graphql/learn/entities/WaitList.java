package com.graphql.learn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "waitlist")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WaitList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "patron_account_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PatronAccount patronAccount;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "book_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Book book;


}
