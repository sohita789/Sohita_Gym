package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Constants.PackageType;

import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;

import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class UpdateRegisterController {

    @Autowired
    public GymService gymService;

    UpdateRegisterController() {
        System.out.println("No-arg const in UpdateController");
    }

    @GetMapping("/updates")
    public String showUpdatePage(Model model) {
        List<PackageType> packages = new ArrayList<>(Arrays.asList(PackageType.values()));
        model.addAttribute("packageType", packages);
        return "UpdateRegister";
    }

    @PostMapping("/searchEmail")
    public String getDetailsByEmail(@RequestParam String email, Model model) {
        RegistrationEntity details = gymService.getDetailsByEmail(email);
        if (details != null) {
            model.addAttribute("details", details);
            return "UpdateRegister";
        }
        return "Success";
    }

    @PostMapping("/updates")
    public String updateDetails(@RequestParam int id,
                                @RequestParam String packageType,
                                @RequestParam String trainerName,
                                @RequestParam double amount,
                                @RequestParam double amountPaid,
                                @RequestParam double balance,
                                @RequestParam int installment, Model model) {
        boolean value = gymService.updateDetailsById(packageType, trainerName, amount, amountPaid, balance, installment, id);
        if (value) {
            return "Success";
        }
        return "UpdateRegister";
    }
}
