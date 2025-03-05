package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.DTO.EnquiryDTO;
import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
import com.xworkz.Sohita_Gym.Entity.EnquiryEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j

public class RegistrationController {

    @Autowired
    GymService gymService;

    RegistrationController() {
        System.out.println("No args constructor in GymController");
    }

    //get all Names From EnquiryEntity in dropdown
    @GetMapping("/register")
    public String displayEnquiryDetails(Model model) {
        System.out.println("displayEnquiryDetails in Controller");
        List<EnquiryEntity> listOfNames = gymService.getAllEnquiry();
        model.addAttribute("listOfNames", listOfNames);
        return "Registration";
    }

    //when select the name ,phoneNo will populate automatically
    @RequestMapping("/getPhoneNumberByName")
    @ResponseBody
    public String getPhoneNumberByName(@RequestParam String name) {
        System.out.println("====----------------getPhoneNumberByName in controller------------------===");
        String phoneNo = gymService.getPhoneNumberByName(name); //fetches the phone number based on name
        System.out.println("phone number of that name:" + phoneNo);
        return phoneNo;
    }

    @PostMapping("/registers")
    public String onRegister(@ModelAttribute RegistrationDTO registrationDTO, Model model) {
        System.out.println("running onRegister method in GymController " + registrationDTO);
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


