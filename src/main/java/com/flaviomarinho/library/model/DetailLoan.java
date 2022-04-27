package com.flaviomarinho.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
