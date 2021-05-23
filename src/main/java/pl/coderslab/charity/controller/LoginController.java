package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class LoginController {

    @GetMapping("/login")
    public String loginActionForm() {

        return "login";
    }

    @GetMapping("/logout")
    public String logoutActionForm() {

        return "index";
    }

    @PostMapping("/logout")
    public String logoutAction() {

        return "index";
    }


}
