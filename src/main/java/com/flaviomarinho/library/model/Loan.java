package com.flaviomarinho.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Loan extends AbstractEntity{

    @OneToOne
    private User user;
    @OneToMany
    private List<DetailLoan> detailLoan;

    //Sistema permite o empréstimo de no máximo dois livros por usuário
    private final int limitLoanForUser = 2;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DetailLoan> getDetailLoan() {
        return detailLoan;
    }

    public void setDetailLoan(List<DetailLoan> detailLoan) {
        this.detailLoan = detailLoan;
    }

    public int getLimitLoanForUser() {
        return limitLoanForUser;
    }
}
