package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
@Slf4j

public class AdminController {

    @Autowired
    GymService gymService;

    AdminController() {
        System.out.println(" Created the No args constructor in AdminController");
    }

    @GetMapping("/SignIn")

    public String onSignIn(@RequestParam("email")String email, @RequestParam("password")String password, Model model) {
        System.out.println("running onSignIn method in AdminController");
        boolean read = gymService.getNameByEmail(email, password);

        if (read) {
            model.addAttribute("msg", "Login Successfully");
            return "LoginSuccess";
        } else {
            model.addAttribute("error", "Login is unSuccessFull");
            return "Admin";
        }
    }
}
