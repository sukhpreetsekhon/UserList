package com.angularPractice.backend.Repositories;

import com.angularPractice.backend.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;


public interface UserRepository extends CrudRepository<User, String> {


    @Override
    Optional<User> findById(String s);

    @Override
    void delete(User user);
}
