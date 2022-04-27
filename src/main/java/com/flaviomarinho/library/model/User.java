package com.flaviomarinho.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User extends AbstractEntity{
    @Column
    private String name;
    @Column
    private String phone;
    @Column
    private String cpf;
    @Column
    private String address;
    @Column
    private Integer availability;
    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Loan> loan;

}