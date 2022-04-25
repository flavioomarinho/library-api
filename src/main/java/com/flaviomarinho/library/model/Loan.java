package com.flaviomarinho.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Loan extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLoan = new java.sql.Date(System.currentTimeMillis());
    @Temporal(TemporalType.DATE)
    private Date dateDevolution = incrementDate();
    @OneToMany(mappedBy = "loan")
    private List<DetailLoan> detailLoans;

    public Loan() {
    }

    public Date getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(Date dateLoan) {
        this.dateLoan = dateLoan;
    }

    public Date getDateDevolution() {
        return dateDevolution;
    }

    public void setDateDevolution(Date dateDevolution) {
        this.dateDevolution = dateDevolution;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DetailLoan> getDetailLoans() {
        return detailLoans;
    }

    public void setDetailLoans(List<DetailLoan> detailLoans) {
        this.detailLoans = detailLoans;
    }

    public Date incrementDate() {
        this.dateDevolution = new Date();
        Calendar cal = Calendar.getInstance();
            cal.setTime(this.dateLoan);
            cal.add(Calendar.DATE, 15);
            return cal.getTime();
    }

    @Override
    public String toString() {
        return "Loan{" +
                "user=" + user +
                '}';
    }
}