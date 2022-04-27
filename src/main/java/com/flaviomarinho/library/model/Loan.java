package com.flaviomarinho.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Loan extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name ="date_loan")
    private LocalDate dateLoan;
    @OneToMany(mappedBy = "loan")
    private List<DetailLoan> itens;

}