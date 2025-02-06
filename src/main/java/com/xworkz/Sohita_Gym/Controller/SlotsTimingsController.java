package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Entity.SlotTimingsEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class SlotsTimingsController {

    @Autowired
    GymService gymService;

    SlotsTimingsController(){
        System.out.println("Created the SlotTimings NoArgs Constructor");
    }

    @GetMapping("/AddSlotact")
    public String onslots(@RequestParam("startTimings") String startTimings, @RequestParam("endTimings") String endTimings,
                          @RequestParam("duration") String duration, Model model) {
        boolean saved = gymService.saveSlots(startTimings, endTimings, duration);
        if (saved) {
            model.addAttribute("successMessage", "DetailsUpdatedSuccessfully");
            List<SlotTimingsEntity> slots = gymService.getAllslots();
            model.addAttribute("slots", slots);
            return "trainerslots";
        }
        model.addAttribute("errorMessage", "Failed ");
        return "trainerslots";
    }
}
