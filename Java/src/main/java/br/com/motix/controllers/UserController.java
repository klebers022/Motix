package br.com.motix.controllers;

import br.com.motix.models.User;
import br.com.motix.models.dto.UserDTO;
import br.com.motix.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String listTasks(Model model){
        model.addAttribute("users", this.userService.findAll());
        return "users/list";
    }

}
