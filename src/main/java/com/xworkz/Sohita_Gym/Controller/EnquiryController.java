package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.DTO.EnquiryDTO;
import com.xworkz.Sohita_Gym.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EnquiryController {

    @Autowired
    GymService gymService;

    EnquiryController() {
        System.out.println(" Created No args constructor in EnquiryController");
    }

    @PostMapping("/Enquiry")
    public String onEnquiry(@ModelAttribute EnquiryDTO enquiryDTO, Model model) {
        System.out.println("running onEnquiry method in GymController " + enquiryDTO);
        boolean isEnquired = gymService.saveEnquiry(enquiryDTO);

        if (isEnquired) {
            model.addAttribute("msg", "Details Enquired SuccessFully");
            return "EnquirySuccess";
        } else {
            model.addAttribute("error", "Enquiry is UnSuccessFull");
            return "Enquiry";
        }
    }

}
