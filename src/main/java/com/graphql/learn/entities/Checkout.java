package com.graphql.learn.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checkout")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Date startTime;

    private Date endTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "book_copy_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private BookCopy bookCopy;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "patron_account_id", nullable = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private PatronAccount patronAccount;

    private Boolean isReturned;
}
