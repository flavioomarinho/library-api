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

    //Busca todos os livros cadastrados
    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(bookDAO.findAll(), HttpStatus.OK);
    }

    //Busca livro pelo titulo
    @GetMapping(value = "/title")
    public ResponseEntity<?> searchForTitle(String title){
        return new ResponseEntity<>(bookDAO.title(title), HttpStatus.OK);
    }

    //Busca livro por autor
    @GetMapping(value = "/author")
    public ResponseEntity<?> searchForAuthor(String author){
        return new ResponseEntity<>(bookDAO.author(author), HttpStatus.OK);
    }

    //Salva livro
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Book book){
        return new ResponseEntity<>(bookDAO.save(book), HttpStatus.OK);
    }

    //Atualiza registro livro
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Book book){
        return bookDAO.findById(id).map(record->{
            record.setAuthor(book.getAuthor());
            record.setGender((book.getGender()));
            record.setSubject(book.getSubject());
            record.setTitle(book.getTitle());
            Book update = bookDAO.save(record);
            return ResponseEntity.ok().body(update);
        }).orElse(ResponseEntity.notFound().build());
    }

    //Deleta registro livro
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete (@PathVariable long id){
        return bookDAO.findById(id).map(record->{
            bookDAO.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }



}
