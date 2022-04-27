package com.flaviomarinho.library.service;

import com.flaviomarinho.library.dto.LoanDTO;
import com.flaviomarinho.library.model.Loan;

public interface LoanService {
    Loan save(LoanDTO dto);
}
