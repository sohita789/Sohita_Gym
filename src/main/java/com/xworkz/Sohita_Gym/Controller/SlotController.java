//package com.xworkz.Sohita_Gym.Controller;
//
//import com.xworkz.Sohita_Gym.DTO.SlotDTO;
//import com.xworkz.Sohita_Gym.Service.SloatSaveService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@Slf4j
//
//@RequestMapping("/")
//public class SlotController {
//
//    @Autowired
//    private SloatSaveService sloatSave;
//
//    public SlotController(){
//        log.info("This is slot controller");
//    }
//
//    @PostMapping("/getDuration")
//    public String timeSlotSave(SlotDTO dto, HttpSession session){
//
//        System.out.println("Start timg: "+dto.getStartTime()+" End time: "+dto.getEndTime()+" Duration: "+dto.getDuration());
//
//        if(sloatSave.onSave(dto)){
//            session.getAttribute("AdminName");
//            return "AddSlots";
//        }
//        return "AddSlots";
//    }
//
//
//}
