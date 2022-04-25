package com.flaviomarinho.library.dto;

import com.flaviomarinho.library.model.Book;

public class DetailLoanDTO {
    private Long book;

    public Long getBook() {
        return book;
    }

    public void setBook(Long book) {
        this.book = book;
    }
}
