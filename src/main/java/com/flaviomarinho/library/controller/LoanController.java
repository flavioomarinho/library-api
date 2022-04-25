package com.flaviomarinho.library.controller;

import com.flaviomarinho.library.dto.LoanDTO;
import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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