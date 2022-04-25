package com.flaviomarinho.library.repository;

import com.flaviomarinho.library.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends CrudRepository <User, Long> {
    List<User> findByName (String name);
    List<User> name (String name);

    @Query(" select u from User u left join fetch u.loan where u.id= :id")
    User findUserFetchLoan(@Param("id") Long id);


}
