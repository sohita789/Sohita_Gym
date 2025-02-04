package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.DTO.EnquiryDTO;
import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Slf4j

public class RegistrationController {
    @Autowired
    GymService gymService;

    RegistrationController() {
        System.out.println("No args constructor in GymController");
    }

    @PostMapping("/register")
    public String onRegister(@ModelAttribute RegistrationDTO registrationDTO, Model model) {
        System.out.println("running onEnquiry method in GymController " + registrationDTO);
        boolean isRegistered = gymService.saveRegister(registrationDTO);

        if (isRegistered) {
            model.addAttribute("msg", "Details Registered SuccessFully");
            return "RegistrationSuccess";
        } else {
            model.addAttribute("error", " Registration is UnSuccessFull");
            return "Registration";
        }
    }
}
