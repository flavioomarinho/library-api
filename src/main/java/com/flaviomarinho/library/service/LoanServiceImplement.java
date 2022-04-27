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
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanServiceImplement implements LoanService{
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final DetailLoanRepository detailLoanRepository;

    //Realiza emprestimo
    @Override
    @Transactional
    public Loan save(LoanDTO dto) {
        Long idUser = dto.getUser();
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuleBussinesException("Código de usuário inválido"));
        Loan loan = new Loan();
        if(user.getAvailability()<2 && dto.getItens().size()<3){
            List<DetailLoan> detailLoans = convertDetails(loan, dto.getItens());
            loan.setDateLoan(LocalDate.now());
            loan.setUser(user);
            User userUpdate = updateAvaiabilityUser(detailLoans,user);
            userRepository.save(userUpdate);
            loanRepository.save(loan);
            detailLoanRepository.saveAll(detailLoans);
            loan.setItens(detailLoans);
            return loan;
        }else{
            return loan;
        }
               }

       public User updateAvaiabilityUser(@NotNull List<DetailLoan> itens, User user){
            if(itens.isEmpty()){
                new RuleBussinesException("Lista vazia");
            }else if(itens.size() == 1) {
                if (user.getAvailability() == 0) {
                    user.setAvailability(1);
                } else if (user.getAvailability() == 1) {
                    user.setAvailability(2);
                }
            }else if(itens.size() == 2){
                user.setAvailability(2);
                }
            return user;
    }

    public List<DetailLoan> convertDetails (Loan loan, List<DetailLoanDTO> itens){
        if(itens.isEmpty()){
            throw new RuntimeException("Não é possível realizar um empréstimo sem livros")  ;
        }else{
            return itens.stream().map(dto -> {
                Long idBook = dto.getBook();
                Book book = bookRepository.findById(idBook).orElseThrow(()-> new RuleBussinesException("Código de Livro inválido: "));
                book.setAvailability(1);
                DetailLoan detailLoan = new DetailLoan();
                detailLoan.setLoan(loan);
                detailLoan.setBook(book);
                return detailLoan;
            }).collect(Collectors.toList());
        }
    }


    }



