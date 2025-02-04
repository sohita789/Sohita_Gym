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
@RequestMapping("/register")

public class RegistrationRestController {
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

    @GetMapping(value = "/age/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAge(@PathVariable String age, Model model) {
        System.out.println("age=" + age);
        long count = gymService.countAge(age);
        if (count > 0) {
            model.addAttribute("disp", "Age exists");
            System.out.println("Age exists");
            return "age exists";
        } else {
            System.out.println("Age doesnt Exists");
            return "Age doesnt exists";
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

    @GetMapping(value = "/phoneNo/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhoneNo(@PathVariable String phoneNo, Model model) {
        System.out.println("phoneNo=" + phoneNo);
        long count = gymService.countPhoneNo(phoneNo);
        if (count > 0) {
            model.addAttribute("disp", "PhoneNo exists");
            System.out.println("PhoneNo exists");
            return "phoneNo exists";
        } else {
            System.out.println("phoneNo doesnt exists");
            return "PhoneNo doesnt exists";
        }
    }

//    @GetMapping(value = "/password/{password}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public String onPassword(@PathVariable String password, Model model) {
//        System.out.println("password=" + password);
//        long count = gymService.countPassword(password);
//        if (count > 0) {
//            model.addAttribute("disp", "Password exists");
//            System.out.println("password exists");
//            return "password exists";
//        } else {
//            System.out.println("Password exists");
//            return "Password doesnt exists";
//        }
//    }

    @GetMapping(value = "/gymName/{gymName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onGymName(@PathVariable String gymName, Model model) {
        System.out.println("gymName=" + gymName);
        long count = gymService.countGymName(gymName);
        if (count > 0) {
            model.addAttribute("disp", "GymName exists");
            System.out.println("GymName  exists");
            return "GymName exists";
        } else {
            System.out.println("GymName doesnt exists");
            return "GymName doesnt exists";
        }
    }

    @GetMapping(value = "/trainerName/{trainerName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onTrainerName(@PathVariable String trainerName, Model model) {
        System.out.println("trainername=" + trainerName);
        long count = gymService.countTrainerName(trainerName);
        if (count > 0) {
            model.addAttribute("disp", "trainerName exists");
            System.out.println("trainerName exists");
            return "TrainerName exists";
        } else {
            System.out.println("TrainerName doesnt exists");
            return "TrainerName doesnt exists";
        }
    }
}