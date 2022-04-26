package com.flaviomarinho.library.service;

import com.flaviomarinho.library.dto.DetailLoanDTO;
import com.flaviomarinho.library.dto.LoanDTO;
import com.flaviomarinho.library.exception.RuleBussinesException;
import com.flaviomarinho.library.model.Book;
import com.flaviomarinho.library.model.DetailLoan;
import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.model.User;
import com.flaviomarinho.library.repository.BookRepository;
import com.flaviomarinho.library.repository.DetailLoanRepository;
import com.flaviomarinho.library.repository.LoanRepository;
import com.flaviomarinho.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImplement implements LoanService{
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final DetailLoanRepository detailLoanRepository;


    @Override
    @Transactional
    public Loan save(LoanDTO dto) {
        Long idUser = dto.getUser();
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuleBussinesException("Código de usuário inválido"));
        Loan loan = new Loan();
        loan.setDateLoan(LocalDate.now());
        loan.setUser(user);
        List<DetailLoan> detailLoans = convertDetails(loan, dto.getItens());
        loanRepository.save(loan);
        detailLoanRepository.saveAll(detailLoans);
        loan.setItens(detailLoans);
            return loan;
       }

    public List<DetailLoan> convertDetails (Loan loan, List<DetailLoanDTO> itens){
        if(itens.isEmpty()){
            throw new RuntimeException("Não é possível realizar um empréstimo sem livros")  ;
        }else{
            return itens.stream().map(dto -> {
                Long idBook = dto.getBook();
                Book book = bookRepository.findById(idBook).orElseThrow(()-> new RuleBussinesException("Código de Livro inválido: "));
                DetailLoan detailLoan = new DetailLoan();
                detailLoan.setLoan(loan);
                detailLoan.setBook(book);
                return detailLoan;
            }).collect(Collectors.toList());
        }
    }

}
