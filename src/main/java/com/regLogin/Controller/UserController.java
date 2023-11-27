package com.regLogin.Controller;

import com.regLogin.Entities.User;
import com.regLogin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserRepository repo;
    @GetMapping("")
    public String homePage(){
        return "index";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register_page";
    }

    @PostMapping("/process_register")
    public String process_register(User user){
        repo.save(user);

        return "register_success";
    }
}
