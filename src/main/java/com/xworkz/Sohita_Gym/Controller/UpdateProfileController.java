//package com.xworkz.Sohita_Gym.Controller;
//
//import com.xworkz.Sohita_Gym.Entity.AdminEntity;
//import com.xworkz.Sohita_Gym.Service.GymService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//
//public class UpdateProfileController {
//
//    @Autowired
//    private GymService gymService;
//
//
//    @RequestMapping(value = "/updatebutton", method = RequestMethod.POST)
//    public String onupdatebutton(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("phoneNo") long phoneNo, @RequestParam("packageType") String packageType, @RequestParam("trainerName") String trainerName, @RequestParam("balance") String balance, @RequestParam("amount") String amount , HttpSession httpSession, Model model) {
//
//        System.out.println(trainerName+packageType);
//        model.addAttribute("id",id);
//        model.addAttribute("name",name);
//        model.addAttribute("phoneNo",phoneNo);
//        model.addAttribute("packageType",packageType);
//        model.addAttribute("trainerName",trainerName);
//        model.addAttribute("amount",amount);
//        model.addAttribute("balance",balance);
////        model.addAttribute("packagesEnumList", packagesEnumList);
////        model.addAttribute("gymTrainersEnums", gymTrainersEnums);
//        AdminEntity entity=(AdminEntity) httpSession.getAttribute("adminEntity");
//
//        model.addAttribute("listing",entity);
//
//        return "UpdateRegistredDetails";
//    }
//
//    @PostMapping("/updateRegister")
//    public String onRegistredDetailsUpdate(int id, String packageType, String trainerName, double amount, double balance, double totalAmount, String name, String phoneNo, Model model, HttpSession session){
//        System.out.println(totalAmount);
//        AdminEntity adminEntity= (AdminEntity)session.getAttribute("adminEntity");
//        String adminName=adminEntity.getName();
//        int updatedVlaue=gymService.upadteRegistredUsersDetails(id,packageType,trainerName,amount,balance,totalAmount,adminName);
//        if(updatedVlaue>0){
//            model.addAttribute("name",name);
//            model.addAttribute("no",phoneNo);
//            model.addAttribute("packageType",packageType);
//            model.addAttribute("trainerName",trainerName);
//            model.addAttribute("balance",balance);
//            model.addAttribute("Amountpaid",amount);
//            model.addAttribute("totalAmount",totalAmount);
//
//
//            model.addAttribute("listing",adminEntity);
//            return "DisplayUpdatedRegistredDetails";
//        }
//        return "UpdateRegistredDetails";
//    }
//}
