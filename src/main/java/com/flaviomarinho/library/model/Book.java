package com.flaviomarinho.library.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;



@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book extends AbstractEntity{
    @Column
    private String title;
    @Column
    private String gender;
    @Column
    private  String author;
    @Column
    private  String subject;
    @Column
    private Integer availability;

}
