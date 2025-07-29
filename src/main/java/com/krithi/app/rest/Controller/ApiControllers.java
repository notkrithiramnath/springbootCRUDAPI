package com.krithi.app.rest.Controller;

import com.krithi.app.rest.Models.User;
import com.krithi.app.rest.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value = "/")
    public String getPage(){
        return "WELCOME!";
    }
    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody User user){
        userRepo.save(user);
        return "Saved yayay";
    }
    @PutMapping(value = "/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setName(user.getName());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        userRepo.save(updatedUser);
        return "Updated yayay";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deletedUser = userRepo.findById(id).get();
        userRepo.delete(deletedUser);
        return "Deleted user of id "+id+ " yayay";
    }


}
