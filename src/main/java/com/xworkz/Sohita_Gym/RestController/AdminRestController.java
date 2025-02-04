package com.xworkz.Sohita_Gym.RestController;

import com.xworkz.Sohita_Gym.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class AdminRestController {
    @Autowired
    private GymService gymService;

    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name, Model model) {
        System.out.println("name=" + name);
        long count = gymService.countName(name);
        if (count > 0) {
            model.addAttribute("disp", "Name exists");
            System.out.println("Name exists");
            return "name exists";
        } else {
            System.out.println("Name doesnt exists");
            return "name doesnt exist";
        }
    }

    @GetMapping(value = "/email/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onEmail(@PathVariable String email, Model model) {
        System.out.println("email=" + email);
        long count = gymService.countEmail(email);
        if (count > 0) {
            model.addAttribute("disp", "Email exists");
            System.out.println("Email exists");
            return "email exists";
        } else {
            System.out.println("Email doesnt exists");
            return "Email doesnt exists";
        }
    }
    @GetMapping(value = "/password/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPassword(@PathVariable String password, Model model) {
        System.out.println("password=" + password);
        long count = gymService.countPassword(password);
        if (count > 0) {
            model.addAttribute("disp", "Password exists");
            System.out.println("password exists");
            return "password exists";
        } else {
            System.out.println("Password exists");
            return "Password doesnt exists";
        }
    }
}
