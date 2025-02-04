package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
import com.xworkz.Sohita_Gym.Entity.ViewEnqDetailsEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j

public class UpdateRegistrationController {
    @Autowired

    GymService gymService;

    UpdateRegistrationController() {

        System.out.println("created the NoArgs UpdateRegistrationController");
    }

    @PostMapping("/updateRegistration")
    public String updateRegister(RegistrationDTO dto, String name, long phoneNo) {
        System.out.println("UpdateRegister method in UpdateRegistation Controller");

        boolean isUpdated = gymService.updateRegister(dto, name, phoneNo);
        if (isUpdated) {
            return "UpdateRegistrationSuccess";
        } else {
            return "UpdateRegistration";
        }
    }
}










