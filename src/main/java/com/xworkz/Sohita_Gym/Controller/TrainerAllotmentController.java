package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Entity.SlotTimingsEntity;
import com.xworkz.Sohita_Gym.Entity.TrainerinfoEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")

public class TrainerAllotmentController {

    @Autowired
    GymService gymService;

    TrainerAllotmentController() {
        System.out.println("created the noArgs constructor TrainerAllotmentController");
    }


//        @GetMapping("/trainersAllotmentact")
//        public String ontrainermanage(Model model) {
//            List<SlotTimingsEntity> slots = gymService.getAllslots();
//            model.addAttribute("slots", slots);
//
//            List<TrainerinfoEntity> trainerinfolist = gymService.getAlltrainerdetails();
//            model.addAttribute("trainerInfoList", trainerinfolist);
//            return "trainerslots";
//        }
//
//
//        @PostMapping("/trainerAddact")
//        public String ontraineradd(@RequestParam("Name") String name, @RequestParam("phoneNumber") String phoneNumber,
//                                   @RequestParam("slotTimings") String slotTimings, Model model) {
//            boolean saved = gymService.savetrainerdetails(name, phoneNumber, slotTimings);
//            if (saved) {
//                List<SlotTimingsEntity> slots = gymService.getAllslots();
//                model.addAttribute("slots", slots);
//
//                List<TrainerinfoEntity> trainerinfoList = gymService.getAlltrainerdetails();
//                model.addAttribute("trainerinfolist", trainerinfoList);
//                model.addAttribute("successMessage", "TrainersDetailsUpdatedSuccessfully");
//                return "trainerslots";
//            }
//            model.addAttribute("errorMessage", "Failed ");
//            return "trainerslots";
//        }
//
//        @GetMapping("trainersSlots")
//        public String displayTrainers( Model model) {
//            List<TrainerinfoEntity> trainerinfolist = gymService.getAlltrainerdetails();
//            trainerinfolist.forEach((n) -> System.out.println(n));
//            model.addAttribute("trainerinfolist", trainerinfolist);
//            //  model.addAttribute("successMessage", "Trainer deleted successFully.");
//            return "trainerslots";
//        }
//
//        @GetMapping("/deleteSlot")
//        public String onDeleteSlot(@RequestParam int id,Model model){
//            boolean deleted= gymService.getDeleteTrainersById(id);
//            if(deleted) {
//                List<TrainerinfoEntity> trainerinfoEntityList = gymService.getAlltrainerdetails();
//                trainerinfoEntityList.forEach((n) -> System.out.println(n));
//                model.addAttribute("trainerinfoEntityList", trainerinfoEntityList);
//                model.addAttribute("SuccessMessage", "TrainerDetails Deleted");
//            }
//            else{
//                model.addAttribute("errorMessage", "Fail to delete");
//            }
//            return "trainerslots";
//        }

    @GetMapping("/trainersAllotmentact")
    public String ontrainermanage(Model model) {
        List<SlotTimingsEntity> slots = gymService.getAllslots();
        model.addAttribute("slots", slots);

        List<TrainerinfoEntity> trainerinfolist = gymService.getAlltrainerdetails();
        model.addAttribute("trainerInfoList", trainerinfolist);
        return "trainerslots";
    }


    @PostMapping("/trainerAddact")
    public String ontraineradd(@RequestParam("Name") String name, @RequestParam("phoneNumber") String phoneNumber,
                               @RequestParam("slotTimings") String slotTimings, Model model) {
        boolean saved = gymService.savetrainerdetails(name, phoneNumber, slotTimings);
        if (saved) {
            List<SlotTimingsEntity> slots = gymService.getAllslots();
            model.addAttribute("slots", slots);

            List<TrainerinfoEntity> trainerinfolist = gymService.getAlltrainerdetails();
            model.addAttribute("trainerInfoList", trainerinfolist);
            model.addAttribute("successMessage", "TrainersDetailsUpdatedSuccessfully");
            return "trainerslots";
        }
        model.addAttribute("errorMessage", "Failed ");
        return "trainerslots";
    }

    @GetMapping("trainersSlots")
    public String displayTrainers( Model model) {
        List<TrainerinfoEntity> trainerinfolist = gymService.getAlltrainerdetails();
        trainerinfolist.forEach((n) -> System.out.println(n));
        model.addAttribute("trainerinfoList", trainerinfolist);
        //  model.addAttribute("successMessage", "Trainer deleted successFully.");
        return "trainerslots";
    }

    @GetMapping("/deleteSlot")
    public String onDeleteSlot(@RequestParam int id,Model model){
        boolean deleted= gymService.getDeleteTrainersById(id);
        if(deleted) {
            List<TrainerinfoEntity> trainerinfoEntityList = gymService.getAlltrainerdetails();
            trainerinfoEntityList.forEach((n) -> System.out.println(n));
            model.addAttribute("trainerinfoEntityList", trainerinfoEntityList);
            model.addAttribute("SuccessMessage", "TrainerDetails Deleted");
        }
        else{
            model.addAttribute("errorMessage", "Fail to delete");
        }
        return "trainerslots";
    }
    }

