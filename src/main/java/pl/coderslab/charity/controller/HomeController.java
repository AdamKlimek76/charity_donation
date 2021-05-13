package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {
    private final InstitutionService institutionService;

    public HomeController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }


    @GetMapping("/")
    public String homeAction(Model model){
        List<Institution> institutions=institutionService.showAll();
        model.addAttribute("institutions", institutions);
        return "index";
    }
}

