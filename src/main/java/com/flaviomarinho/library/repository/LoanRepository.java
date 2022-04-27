package com.flaviomarinho.library.repository;

import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoanRepository extends CrudRepository<Loan, Long> {
    List<Loan> findByUser(User user);
}
