package org.launchcode.controllers;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("")
    public String displayAddUserFrom() {
        return "/user/add";
    }

    @PostMapping("")
    public String processAddUserFrom(Model model, @ModelAttribute User user, String verify) {
        // add from submission handling
        if (!user.getPassword().equals(verify)) {
            model.addAttribute("username", user.getUsername());
            model.addAttribute("email", user.getEmail());
            model.addAttribute("error", "Passwords do not match.");
            return "/user/add";
        }
        model.addAttribute("user", user);
        return "/user/index";
    }

}
