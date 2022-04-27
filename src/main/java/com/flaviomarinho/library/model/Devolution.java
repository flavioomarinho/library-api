package com.flaviomarinho.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Devolution extends AbstractEntity {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne
    @JoinColumn(name="book_id")
    private Book book;

    @Column(name ="date_devolution")
    private LocalDate dateDevolution;

}
