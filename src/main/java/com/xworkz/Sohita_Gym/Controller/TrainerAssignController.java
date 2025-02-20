package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Constants.GymTrainersNameEnum;
import com.xworkz.Sohita_Gym.DTO.AssignTrainerDTO;
import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
import com.xworkz.Sohita_Gym.Entity.TrainerinfoEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/")
public class TrainerAssignController {

    @Autowired
    private GymService gymService;

    private List<GymTrainersNameEnum> trainerNames = new ArrayList<>(Arrays.asList(GymTrainersNameEnum.values()));

    public TrainerAssignController() {
        System.out.println("created TrainerAssignController");
    }

    @PostMapping("/assignTrainer")
    public String saveAssignTrainerDetails(AssignTrainerDTO assignTrainerDTO, Model model) {
        System.out.println("saveAssignTrainerDetails");
        boolean savedData = gymService.saveTrainerAssignDetails(assignTrainerDTO);
        if (savedData) {
            model.addAttribute("msg", "saved data");
            return "Success";
        } else {
            model.addAttribute("error", "Not Saved");
            return "AssignTrainersToUser";
        }
    }

        //fetching data from two tables
        @GetMapping("/noTrainer")

        public String displayDetails (Model model){
            System.out.println("displayDetails in controller");
            // Fetch customer details without trainer
            List<RegistrationEntity> customerList = gymService.getAllDetails();
            System.out.println("=============:"+customerList);
            // Fetch trainer details
            List<TrainerinfoEntity> trainerList = gymService.getTrainerDetails();

            // Add both lists to the model
            model.addAttribute("noTrainerList", customerList);
            model.addAttribute("TrainerEntityList", trainerList);

            // Return the same JSP view with both data sets
            return "AssignTrainersToUser";  // Same JSP for both sets of data
        }

        //updating trainerName and Timing slots
        @PostMapping("/trainee{id}")
        public String assignTrainerToUsers ( @PathVariable int id, @RequestParam String trainerName, String slotTimings)
        {

            System.out.println("Id from the customer with trainer details: " + id + " " + trainerName + " " + slotTimings + "");

            TrainerinfoEntity trainerEntity = gymService.getByIdToAssignTrainer(id, trainerName, slotTimings);
            if (trainerEntity != null) {
                return "Success";
            }
            return "AssignTrainersToUser";
        }
    }







