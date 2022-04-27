package com.flaviomarinho.library.service;

import com.flaviomarinho.library.dto.DevolutionDTO;
import com.flaviomarinho.library.exception.RuleBussinesException;
import com.flaviomarinho.library.model.Book;
import com.flaviomarinho.library.model.Devolution;
import com.flaviomarinho.library.model.User;
import com.flaviomarinho.library.repository.BookRepository;
import com.flaviomarinho.library.repository.DevolutionRepository;
import com.flaviomarinho.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class DevolutionServiceImplement implements DevolutionService{

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final DevolutionRepository devolutionRepository;

    //Realiza devolução
    @Override
    public Devolution update(DevolutionDTO dto) {
        Long idUser = dto.getUser();
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuleBussinesException("Código de usuário inválido"));
        User userUpdate = updateAvailabilityUser(user);
        Long idBook = dto.getBook();
        Book book = bookRepository.findById(idBook).orElseThrow(()-> new RuleBussinesException("Código do livro inválido"));
        book.setAvailability(0);
        Devolution devolution = new Devolution();
        devolution.setDateDevolution(LocalDate.now());
        devolution.setUser(userUpdate);
        devolution.setBook(book);
        userRepository.save(userUpdate);
        bookRepository.save(book);
        devolutionRepository.save(devolution);
        return devolution;
    }

    //Altera disponibilidade do usuário conforme número de livros devolvidos
    public User updateAvailabilityUser(User user){
        if(user.getAvailability() == 2){
            user.setAvailability(1);
        }else if(user.getAvailability() == 1){
            user.setAvailability(0);
        }
        return user;
    }
}
