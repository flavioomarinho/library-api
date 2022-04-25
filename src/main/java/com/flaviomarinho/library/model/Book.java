package com.flaviomarinho.library.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

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
    private Boolean availability;

    public Book(String title, String gender, String author, String subject, Boolean availability) {
        this.title = title;
        this.gender = gender;
        this.author = author;
        this.subject = subject;
        this.availability = availability;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }
}
