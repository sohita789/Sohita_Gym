//package com.xworkz.Sohita_Gym.Controller;
//
//import com.xworkz.Sohita_Gym.Constants.GymTrainersNameEnum;
//import com.xworkz.Sohita_Gym.DTO.TrainerTimeAllotment;
//import com.xworkz.Sohita_Gym.Entity.SlotEntity;
//import com.xworkz.Sohita_Gym.Entity.TrainerTimeAllotmentEntity;
//import com.xworkz.Sohita_Gym.Service.SloatSaveService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.view.RedirectView;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//@Slf4j
//@RequestMapping("/")
//public class TrainerAllotementController {
//
//    @Autowired
//    private SloatSaveService sloatSaveService;
//
//    List<GymTrainersNameEnum> trainers = new ArrayList<>(Arrays.asList(GymTrainersNameEnum.values()));
//
//    public TrainerAllotementController(){
//        log.info("This is trainer Allotment class");
//    }
//
//
//    @GetMapping("/trainerAllotment")
//    public String trainerAllotmentRedirect(Model model){
//
//        model.addAttribute("trainerNames", trainers);
//
//        List<SlotEntity> slotEntities = sloatSaveService.getSlots();
//
//        List<String> time  = new ArrayList<>();
//        for(SlotEntity slot: slotEntities){
//            time.add(slot.getStartTime());
//        }
//        model.addAttribute("startTime", time);
//
//        List<String> timing = new ArrayList<>();
//        for(SlotEntity slot: slotEntities){
//            timing.add(slot.getEndTime());
//        }
//        model.addAttribute("endTime", timing);
//        return "SlotAllotment";
//    }
//
//    @PostMapping("/trainerTimingAllotment")
//    public String timeAllotemntToTrainer(TrainerTimeAllotment dto, Model model){
//
//        log.info("The name is: "+dto.getName());
//        log.info("The phone number is: "+dto.getPhone());
//        log.info("The start time: "+dto.getTimeRange());
//        model.addAttribute("trainerNames", trainers);
//
//        List<String> startTimeList = new ArrayList<>();
//        List<String> endTimeList = new ArrayList<>();
//
//        List<SlotEntity> slotEntities = sloatSaveService.getSlots();
//
//        for (SlotEntity slot : slotEntities) {
//            startTimeList.add(slot.getStartTime());
//            endTimeList.add(slot.getEndTime());
//        }
//
//        model.addAttribute("startTime", startTimeList);
//        model.addAttribute("endTime", endTimeList);
//
////        List<TrainerTimeAllotmentEntity> trainerTimeAllotmentEntities = sloatSaveService.getDetails();
////        model.addAttribute("trainerTimeAllotmentEntities", trainerTimeAllotmentEntities);
//
//        if(sloatSaveService.trainerAllotment(dto)){
//            return "SlotAllotment";
//        }
//        return "Success";
//    }
//
//
//    @GetMapping("/viewDetails")
//    public String returnTrainerDetails(Model model){
//
//        List<TrainerTimeAllotmentEntity> trainerTimeAllotmentEntities = sloatSaveService.getDetails();
//        if(trainerTimeAllotmentEntities != null) {
//            model.addAttribute("trainerTimeAllotmentEntities", trainerTimeAllotmentEntities);
//            return "TrainerDetails";
//        }
//        return "";
//    }
//
//    @GetMapping("/remove/{id}")
//    public RedirectView deleteTrainer(@PathVariable("id") int id, Model model, HttpServletRequest req){
//        log.info("Id is: "+id);
//
//        if(sloatSaveService.deleteTrsiner(id)){
//            List<TrainerTimeAllotmentEntity> trainerTimeAllotmentEntities = sloatSaveService.getDetails();
//            model.addAttribute("trainerTimeAllotmentEntities", trainerTimeAllotmentEntities);
//            return new RedirectView(req.getContextPath()+"/viewDetails");
//        }
//        return new RedirectView(req.getContextPath()+"/viewDetails");
//    }
//}
//
//
