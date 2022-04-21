package com.flaviomarinho.library.repository;

import com.flaviomarinho.library.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserRepository extends CrudRepository <User, Long> {
    List<User> findByName (String name);
    List<User> name (String name);


}
