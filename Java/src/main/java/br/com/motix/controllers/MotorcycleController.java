package br.com.motix.controllers;


import br.com.motix.models.Motorcycle;
import br.com.motix.models.User;
import br.com.motix.services.MotorcycleService;
import br.com.motix.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bikes")
public class MotorcycleController {

    @Autowired
    private MotorcycleService motorcycleService;

    @GetMapping
    public List<Motorcycle> findAll() {
        return motorcycleService.findAll();
    }

}
