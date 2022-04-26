package com.flaviomarinho.library.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class DetailLoan extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name="loan_id")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;
}
