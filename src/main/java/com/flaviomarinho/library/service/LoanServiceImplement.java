package com.flaviomarinho.library.service;

import com.flaviomarinho.library.dto.DetailLoanDTO;
import com.flaviomarinho.library.dto.LoanDTO;
import com.flaviomarinho.library.model.Book;
import com.flaviomarinho.library.model.DetailLoan;
import com.flaviomarinho.library.model.Loan;
import com.flaviomarinho.library.model.User;
import com.flaviomarinho.library.repository.BookRepository;
import com.flaviomarinho.library.repository.DetailLoanRepository;
import com.flaviomarinho.library.repository.LoanRepository;
import com.flaviomarinho.library.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImplement implements LoanService{
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final DetailLoanRepository detailLoanRepository;


    public LoanServiceImplement(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository, DetailLoanRepository detailLoanRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.detailLoanRepository = detailLoanRepository;
    }

    @Override
    @Transactional
    public Loan saveLoan(LoanDTO dto) {
        Long idUser = dto.getUser();
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("Código de usuário inválido"));
        Loan loan = new Loan();
        loan.setUser(user);
        List<DetailLoan> detailLoans = convertDetails(loan, dto.getDetailLoanDTOS());
        loanRepository.save(loan);
        detailLoanRepository.saveAll(detailLoans);
        loan.setDetailLoans(detailLoans);
        return loan;
    }

    public List<DetailLoan> convertDetails (Loan loan, List<DetailLoanDTO> detailLoanDTOS){
        if(detailLoanDTOS.isEmpty()){
            throw new RuntimeException("Não é possível realizar um empréstimo sem livros")  ;
        }else{
            return detailLoanDTOS.stream().map(dto -> {
                Long idBook = dto.getBook();
                Book book = bookRepository.findById(idBook).orElseThrow(()-> new RuntimeException("Código de Livro inválido: "+idBook));
                DetailLoan detailLoan = new DetailLoan();
                detailLoan.setLoan(loan);
                detailLoan.setBook(book);
                return detailLoan;
            }).collect(Collectors.toList());
        }
    }
}
