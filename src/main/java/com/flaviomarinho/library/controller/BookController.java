package com.flaviomarinho.library.controller;

import com.flaviomarinho.library.model.Book;
import com.flaviomarinho.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")

public class BookController {
    private final BookRepository bookDAO;
    @Autowired
    public BookController(BookRepository bookDAO) {
        this.bookDAO = bookDAO;
    }
    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(bookDAO.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Book book){
        return new ResponseEntity<>(bookDAO.save(book), HttpStatus.OK);
    }


}
