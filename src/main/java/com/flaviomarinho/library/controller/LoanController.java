package com.flaviomarinho.library.controller;

import com.flaviomarinho.library.dto.LoanDTO;
import com.flaviomarinho.library.model.Book;
import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.repository.LoanRepository;
import com.flaviomarinho.library.service.LoanService;
import org.apache.catalina.LifecycleState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Long save (@RequestBody LoanDTO dto){
        Loan loan = service.saveLoan(dto);
        return loan.getId();
    }
}