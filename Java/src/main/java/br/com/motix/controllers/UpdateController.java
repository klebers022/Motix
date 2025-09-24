package br.com.motix.controllers;


import br.com.motix.models.Motorcycle;
import br.com.motix.models.Update;
import br.com.motix.models.User;
import br.com.motix.models.dto.UpdateDTO;
import br.com.motix.services.interfaces.MotorcycleService;
import br.com.motix.services.interfaces.UpdatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/update")
public class UpdateController {

    private final UpdatesService updatesService;

    public UpdateController(UpdatesService updatesService) {
        this.updatesService = updatesService;
    }

    @GetMapping
    public String listUpdates(Model model) {
        model.addAttribute("updates", updatesService.findAll());
        return "updates/list";
    }
}