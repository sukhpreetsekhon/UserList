package com.angularPractice.backend.Controllers;

import com.angularPractice.backend.Models.User;
import com.angularPractice.backend.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Iterable<User> UserList(){
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User createUser(@RequestBody User user){

        userRepository.save(user);
        return user;

    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public Optional<User> show(@PathVariable String id) {
        return userRepository.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
    public User update(@PathVariable String id, @RequestBody User user){

        User updateUser = userRepository.findById(id).get();
        if (user.getFirstName() != null){
            updateUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName()!=null){
            updateUser.setLastName(user.getLastName());
        }
        userRepository.save(updateUser);
        return user;

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public String delete(@PathVariable String id){

        User deleteUser = userRepository.findById(id).get();
        userRepository.delete(deleteUser);
        return "";
    }

}
