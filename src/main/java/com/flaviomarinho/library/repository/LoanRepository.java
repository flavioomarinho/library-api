package com.flaviomarinho.library.repository;

import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends CrudRepository<Loan, Long> {
    List<Loan> findByUser(User user);

    @Query(" select l from Loan l left join fetch l.itens where l.id =:id")
    Optional<Loan> findByIdFetchItens (@Param("id") Long id);
}
