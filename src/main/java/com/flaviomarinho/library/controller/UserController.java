package com.flaviomarinho.library.controller;

import com.flaviomarinho.library.model.User;
import com.flaviomarinho.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("users")
public class UserController {
    private final UserRepository userDAO;

    @Autowired
    public UserController(UserRepository userDAO) {
        this.userDAO = userDAO;
    }
    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user){
        return new ResponseEntity<>(userDAO.save(user), HttpStatus.OK);
    }





}
