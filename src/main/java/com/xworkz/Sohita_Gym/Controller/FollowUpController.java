package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Constants.StatusEnum;
import com.xworkz.Sohita_Gym.DTO.ViewEnqDetailsDTO;
import com.xworkz.Sohita_Gym.DTO.ViewEnqDetailsDTO;
import com.xworkz.Sohita_Gym.Entity.EnquiryEntity;
import com.xworkz.Sohita_Gym.Entity.ViewEnqDetailsEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j
public class FollowUpController {

    @Autowired
    GymService gymService;

    FollowUpController() {
        System.out.println("created the No-Args Constructor For FollowUpController");
    }

    @PostMapping("updateFollowUp")
    public String onFollowUpUpdate(@RequestParam String name, @RequestParam String status, @RequestParam String reasons, Model model) {
        System.out.println(name);

        boolean followed = gymService.updateStatusAndReason(name, status, reasons);
        if (followed) {
            List<EnquiryEntity> enquiryEntityList = gymService.getEnquiries();
            if (enquiryEntityList != null) {
                enquiryEntityList.forEach((n) -> System.out.println(n));
                model.addAttribute("enquiryEntityList", enquiryEntityList);
                model.addAttribute(("statusOptions"), Arrays.asList(StatusEnum.values()));
                return "FollowUp";
            }
        }
        return "FollowUp";
    }

    @GetMapping("search")
    public String onFollow(@RequestParam(value = "status", required = false) String status, Model model) {
        List<EnquiryEntity> enquiryEntityList;

        System.out.println(status);
        if (status != null && !status.isEmpty()) {
            enquiryEntityList = gymService.getEnquiriesByStatus(status);
        } else {
            enquiryEntityList = gymService.getEnquiries();
        }
        model.addAttribute("enquiryList", enquiryEntityList);
        model.addAttribute("statusOptions", Arrays.asList(StatusEnum.values()));
        model.addAttribute("selectedStatus", status);

        return "FollowUp";
    }

    @PostMapping("/saveview")
    public String saveView(ViewEnqDetailsDTO viewEnqDetailsDTO) {
        boolean display = gymService.saveView(viewEnqDetailsDTO);
        if (display) {
            return "Success";
        } else {
            return "ViewEnquiryDetails";
        }
    }

    @GetMapping("/view")
    public String viewPage(@RequestParam int enquiryId, Model model) {
        System.out.println("View method in the followUpController");
        List<ViewEnqDetailsEntity> enquiryList = gymService.getAllData(enquiryId);
        System.out.println("viewDetails in controller==" + enquiryList);
        model.addAttribute("enquiryList", enquiryList);
        return "ViewEnquiryDetails";
    }
}

