//package com.xworkz.Sohita_Gym.Controller;
//
//import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
//import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
//import com.xworkz.Sohita_Gym.Entity.ViewEnqDetailsEntity;
//import com.xworkz.Sohita_Gym.Service.GymService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//@RequestMapping("/")
//@Slf4j
//
//public class UpdateRegistrationController {
////    @Autowired
////
////    GymService gymService;
////
////    UpdateRegistrationController() {
////
////        System.out.println("created the NoArgs UpdateRegistrationController");
////    }
////
////    @PostMapping("/updateRegistration")
////    public String updateRegister(RegistrationDTO dto, String name, long phoneNo) {
////        System.out.println("UpdateRegister method in UpdateRegistation Controller");
////
////        boolean isUpdated = gymService.updateRegister(dto, name, phoneNo);
////        if (isUpdated) {
////            return "UpdateRegistrationSuccess";
////        } else {
////            return "UpdateRegistration";
////        }
//
//    @Autowired
//    GymService gymService;
//
//    @GetMapping("/update")
//    public String showUpdatePage(Model model) {
//        List<PackageTypeEnum> packages = new ArrayList<>(Arrays.asList(PackageTypeEnum.values()));
//        model.addAttribute("packages", packages);
//        return "Update";
//    }
//
//    @PostMapping("/searchEmail")
//    public String getDetailsByEmail(@RequestParam String email, Model model) {
//        UpdateRegistrationEntity details = gymService.getDetailsByEmail(email);
//        if (details != null) {
//            model.addAttribute("details", details);
//            return "Update";
//        }
//        return "Success";
//    }
//
//    @PostMapping("/update")
//    public String updateDetails(@RequestParam int id,
//                                @RequestParam String packages,
//                                @RequestParam String trainer,
//                                @RequestParam double amount,
//                                @RequestParam double paidAmount,
//                                @RequestParam double balance,
//                                @RequestParam int installment, Model model) {
//        boolean value = gymService.updateDetailsById(packages, trainer, amount, paidAmount, balance, installment, id);
//        if (value) {
//            return "UpdateValueSuccess";
//        }
//        return "Success";
//    }
//}
//}
//
//
//
//
//
//
//
//
//
//
