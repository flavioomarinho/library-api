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

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody User user){
    return userDAO.findById(id).map(record->{
        record.setName(user.getName());
        record.setAddress(user.getAddress());
        record.setCpf(user.getCpf());
        record.setPhone(user.getPhone());
        User update = userDAO.save(record);
        return ResponseEntity.ok().body(update);
    }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<?> delete (@PathVariable long id){
        return userDAO.findById(id).map(record->{
            userDAO.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }





}
