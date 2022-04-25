package com.flaviomarinho.library.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
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
    private Boolean availability = true;

   }
