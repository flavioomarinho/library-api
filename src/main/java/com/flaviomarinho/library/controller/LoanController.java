package com.flaviomarinho.library.controller;

import com.flaviomarinho.library.dto.LoanDTO;
import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.service.LoanService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("loan")
public class LoanController {

    private LoanService service;

    public LoanController(LoanService service) {
        this.service = service;

    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Long save (@RequestBody LoanDTO dto){
        Loan loan = service.save(dto);
        if(loan.getUser() != null){
            return loan.getId();
        }else{
            return Long.valueOf(0);
        }
    }


}