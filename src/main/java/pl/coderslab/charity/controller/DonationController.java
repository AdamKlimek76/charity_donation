package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("donation/")
public class DonationController {
    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;

    public DonationController(CategoryService categoryService, InstitutionService institutionService, DonationService donationService) {
        this.categoryService = categoryService;
        this.institutionService = institutionService;
        this.donationService = donationService;
    }

    @GetMapping("/add")
    public String showDonationForm(Model model) {
        model.addAttribute("donationToAdd", new Donation());

        return "form";
    }

    @PostMapping("/add")
    public String addDonation(@ModelAttribute("donationToAdd")
                              @Valid Donation donation, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }
        donationService.add(donation);
        return "form_confirmation";
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryService.showAll();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions() {
        return institutionService.showAll();
    }

}
