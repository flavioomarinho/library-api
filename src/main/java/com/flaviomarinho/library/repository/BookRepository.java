package com.flaviomarinho.library.repository;

import com.flaviomarinho.library.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle (String title);
    List<Book> title (String title);
    List<Book> author (String author);
}
