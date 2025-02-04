package com.xworkz.Sohita_Gym.RestController;

import com.xworkz.Sohita_Gym.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enquire")
public class EnquiryRestController {

    @Autowired
    private GymService gymService;


    @GetMapping(value = "/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onName(@PathVariable String name, Model model) {
        System.out.println("name=" + name);
        long count = gymService.countName(name);
        if (count > 0) {
            model.addAttribute("disp", "Name exists");
            System.out.println("Name exists");
            return "name exists";
        } else {
            System.out.println("Name doesnt exists");
            return "name doesnt exist";
        }
    }

    @GetMapping(value = "/age/{age}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onAge(@PathVariable String age, Model model) {
        System.out.println("age=" + age);
        long count = gymService.countAge(age);
        if (count > 0) {
            model.addAttribute("disp", "Age exists");
            System.out.println("Age exists");
            return "age exists";
        } else {
            System.out.println("Age doesnt Exists");
            return "Age doesnt exists";
        }
    }
    @GetMapping(value = "/phoneNo/{phoneNo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String onPhoneNo(@PathVariable String phoneNo, Model model) {
        System.out.println("phoneNo=" + phoneNo);
        long count = gymService.countPhoneNo(phoneNo);
        if (count > 0) {
            model.addAttribute("disp", "PhoneNo exists");
            System.out.println("PhoneNo exists");
            return "phoneNo exists";
        } else {
            System.out.println("phoneNo doesnt exists");
            return "PhoneNo doesnt exists";
        }
    }

}
