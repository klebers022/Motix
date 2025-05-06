package br.com.motix.controllers;

import br.com.motix.models.User;
import br.com.motix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable UUID id){
        return userService.findById(id);
    }

    @GetMapping("/rm{rm}")
    public User findByRm(@PathVariable String rm){
        return userService.findByRm(rm);
    }

    @GetMapping("/{name}")
    public User findByName(@PathVariable String name){
        return userService.findByRm(name);
    }

}
