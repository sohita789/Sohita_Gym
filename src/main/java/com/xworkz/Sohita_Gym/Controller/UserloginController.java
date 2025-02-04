package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Slf4j
@Component
@Controller
@RequestMapping("/")

public class UserloginController {
    @Autowired
    GymService gymService;

    UserloginController() {
        System.out.println("created the Constructor UserLoginController");
    }
    @GetMapping("/UserLogin")
    public String onLogin() {
        return "UserLogin";
    }

    @PostMapping("/user")
    public String userLogin(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("userLogin in controller");
        RegistrationEntity display = gymService.userSave(email, password);
        int logInCount;
        if (display != null) {
            logInCount = display.getCount();
            System.out.println("Login Count:" + logInCount);

            if (logInCount == -1) {
                System.out.println("Redirecting to UpdatePassword page.");
                String name = display.getName();
                model.addAttribute("Name", name);
                System.out.println(name);
                model.addAttribute("msg", "UserSuccess");
                return "ResetPassword";
            } else {
                System.out.println("Redirecting to Success page.");
                String name = display.getName();
                model.addAttribute("Name", name);
                //model.addAttribute("filePath",userEntity.getFilePath());
                return "Success";
            }

        } else {
            System.out.println("User entity is null. Redirecting to SignIn.");
            model.addAttribute("msg", "User not Success");
            return "UserLogin";
        }
    }


    //Password reset
    @PostMapping("/resetPassword")
    public String setNewPassword(@RequestParam String name,@RequestParam String oldPassword, @RequestParam String newPassword, @RequestParam String confirmPassword) {

     System.out.println("name==" + name);
     System.out.println("newPassword==" + newPassword);
     System.out.println("confirmPassword==" + confirmPassword);

       // Object gymService = null;
        String msg = gymService.updatePasswordByName(name, oldPassword, newPassword, confirmPassword);

        if ("password updated successfully".equals(msg)) {
            return "ForgetPassword";
        } else {
            return "ResetPassword";
        }
    }

    //forget Password
    @PostMapping("/forgetPassword")
    public String forgotPassword(@RequestParam String email,@RequestParam String newPassword,@RequestParam String confirmPassword) {
        System.out.println("Received request for resetting password:");
        System.out.println("Email:" + email);
        System.out.println("New Password:" + newPassword);
        System.out.println("ConfirmPassword:" + confirmPassword);

        String response = gymService.resetPasswordByEmail(email, newPassword, confirmPassword);

        if ("password updated successfully".equals(response)) {
            return "Success";
        } else {
            return "ForgetPassword";
        }
    }}

