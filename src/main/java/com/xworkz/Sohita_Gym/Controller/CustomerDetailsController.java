//package com.xworkz.Sohita_Gym.Controller;
//
//import com.xworkz.Sohita_Gym.Constants.GymTrainersNameEnum;
//import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
//import com.xworkz.Sohita_Gym.Service.GymService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//@Slf4j
//@RequestMapping("/")
//public class CustomerDetailsController {
//
//    @Autowired
//    private GymService gService;
//
//    private List<GymTrainersNameEnum> trainerNAmes = new ArrayList<>(Arrays.asList(GymTrainersNameEnum.values()));
//
//    public CustomerDetailsController(){
//        log.info("This is from the CustomerDetailsController");
//    }
//
//
//    @GetMapping("/noTrainer")
//    public String displayDetail(Model model){
//
//        List<RegistrationEntity> list = gService.getAllDetails();
//        if(list!=null){
//            model.addAttribute("noTrainerList", list);
//            return "CustomrtWithNoData";
//        }
//        return "Success";
//    }
//
//    @GetMapping("/customerTrainer")
//    public String customerWithTrainer(Model model){
//
//        List<RegistrationEntity> list = gService.getCustomrtDetailsWithTrainer();
//        if(list!=null){
//            model.addAttribute("customrtWithTrainer", list);
//            model.addAttribute("trainers", trainerNAmes);
//            return "CustomrtWithTrainer";
//        }
//        return "Success";
//    }
//
//    @PostMapping("/assign/{id}")
//    public String assignTrainer(@PathVariable int id, @RequestParam String trainer, String timeRange){
//        System.out.println("Id from the customer with trainer details: "+id+ " "+ trainer);
//        RegistrationEntity registerEntity = gService.getDatabyIdToAssigntrainer(id, trainer);
//        if(registerEntity!=null){
//            return "Success";
//        }
//        return "";
//    }
//}
