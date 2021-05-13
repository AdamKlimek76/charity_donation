package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public HomeController(InstitutionService institutionService, DonationService donationService) {
        this.institutionService = institutionService;
        this.donationService = donationService;
    }


    @GetMapping("/")
    public String homeAction(Model model) {
        List<Institution> institutions = institutionService.showAll();
        model.addAttribute("institutions", institutions);

        Integer quantity = donationService.showQuantity();
        model.addAttribute("quantity", quantity);

        Integer donationsNumber=donationService.showDonationsNumber();
        model.addAttribute("donationsNumber", donationsNumber);

        return "index";
    }
}

