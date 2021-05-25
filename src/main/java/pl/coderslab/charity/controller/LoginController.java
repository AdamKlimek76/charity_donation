package pl.coderslab.charity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginActionForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegistration(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String createNewUser(@Valid User user, BindingResult bindingResult, Model model) {
        Optional<User> newUserCheckedIfExist = userService.findByUserName(user.getUsername());
        newUserCheckedIfExist.ifPresent(x -> bindingResult.rejectValue("username", "error.user",
                "Użytkownik o podanej nazwie już istnieje"));
        if (bindingResult.hasErrors()) {
            return "register";
        }
        userService.saveUser(user);
        model.addAttribute("successMessage", "Użytkownik został poprawnie zarejestrowany");
        model.addAttribute("user", new User());
        return "register";
    }

}
