package pl.coderslab.charity.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.charity.model.Donation;

@Controller
@RequestMapping("institution/")
public class InstitutionController {


    @GetMapping("/add")
    @ResponseBody
    public String showInstitutionForm(Model model) {

        return "foundation test";
    }



}
