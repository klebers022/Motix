package br.com.motix.controllers.view;


import br.com.motix.models.Motorcycle;
import br.com.motix.models.enums.BikeType;
import br.com.motix.models.enums.Sectors;
import br.com.motix.services.interfaces.MotorcycleService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/motorcycles")
public class MotorcycleViewController {

    private final MotorcycleService motorcycleService;

    public MotorcycleViewController(MotorcycleService motorcycleService) {
        this.motorcycleService = motorcycleService;
    }

    @GetMapping
    public String listMotorcycle(Model model) {
        model.addAttribute("motorcycles", motorcycleService.findAll());
        return "motorcycles/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("motorcycle", new Motorcycle());
        model.addAttribute("type", BikeType.values());
        model.addAttribute("sectors", Sectors.values());
        return "motorcycles/form";
    }

    @PostMapping("/save")
    public String saveMotorcycle(@Valid @ModelAttribute("motorcycle") Motorcycle motorcycle,
                                 BindingResult bindingResult, Model model) {
        System.out.println("motorcycle: " + motorcycle);
        if (bindingResult.hasErrors()) {
            model.addAttribute("type", BikeType.values());
            model.addAttribute("sectors", Sectors.values());
            return "motorcycles/form";
        }
        this.motorcycleService.postMotorcycle(motorcycle);
        System.out.println("RICARDO SAFADO");
        return "redirect:/motorcycles";
    }

    @GetMapping("delete/{id}")
    public String deleteMotorcycle(@PathVariable("id") UUID  id){
        this.motorcycleService.deleteMotorcycleById(id);
        return "redirect:/motorcycles";
    }

    @GetMapping("/view/{id}")
    public String viewMotorcycle(@PathVariable("id") UUID id, Model model){
        Motorcycle motorcycle = this.motorcycleService.findById(id);
        model.addAttribute("motorcycle", motorcycle);
        return "motorcycles/view";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") UUID id, Model model){
        Motorcycle newMotorcycle = this.motorcycleService.findById(id);
        model.addAttribute("motorcycle", newMotorcycle);
        model.addAttribute("type", BikeType.values());
        model.addAttribute("sectors", Sectors.values());
        return "motorcycles/form";
    }

}

