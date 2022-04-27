package com.flaviomarinho.library.repository;

import com.flaviomarinho.library.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository <User, Long> {
    List<User> findByName (String name);




}
