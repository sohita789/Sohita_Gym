package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.Constants.ProfileImagePath;
import com.xworkz.Sohita_Gym.DTO.UserExerciseAndDietDTO;
import com.xworkz.Sohita_Gym.Entity.AdminEntity;
import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
import com.xworkz.Sohita_Gym.Entity.UserExerciseAndDietEntity;
import com.xworkz.Sohita_Gym.Entity.UserUpdatedExerciseAndDietEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
public class UpdateExerciseAndDietController {
    @Autowired
    private GymService gymService;


    @GetMapping("/UpdateExerciseAndDiet")
    public String onupdate(HttpSession httpSession, Model model){
        System.out.println("=============onUpdate in UpdateExerciseAndDietController============= ");
        List<RegistrationEntity> list=gymService.getAllRegistredUsersDetails();
        System.out.println("===========:"+list);
        AdminEntity adminEntity=(AdminEntity) httpSession.getAttribute("adminEntity");
        model.addAttribute("listimg",adminEntity);
        model.addAttribute("list",list);

        return "UpdateUserExerciseAndDiet";
    }

    @RequestMapping("/searchUser")
    public String onSearch(String searchName,Long searchPhoneNo,Model model,HttpSession httpSession){
        System.out.println("onSearch in UpdateExerciseAndDietController");
        List<RegistrationEntity> registrationEntityList=gymService.getAllRegistredUsersDetailsByNameAndPhoneNo(searchName,searchPhoneNo);
        System.out.println(registrationEntityList);
        AdminEntity entity=(AdminEntity) httpSession.getAttribute("adminEntity");
       System.out.println("entity:"+entity);
        model.addAttribute("listimg",entity);

        if(registrationEntityList.isEmpty()){
            model.addAttribute("listimg",entity);
            model.addAttribute("notFound","No One Registred With This Name And Phone Number. Please Check Name And Phone Number");
            return "UpdateUserExerciseAndDiet";
        }
        model.addAttribute("list",registrationEntityList);
        return "UpdateUserExerciseAndDiet";
    }

    @GetMapping("/updateDiet")
    public String onupdateDiet(@RequestParam("id") int id , HttpSession httpSession, Model model){
        System.out.println("onUpdateDiet in UpdateExerciseAndDietController");
        AdminEntity adminEntity=(AdminEntity) httpSession.getAttribute("adminEntity") ;
        model.addAttribute("list",adminEntity);
        System.out.println(id);
        model.addAttribute("Userid",id);//edited id as userid//
        return "ExerciseAndDiet";
    }

//    @PostMapping("/exercisediet")
//    public String onUpdate(
//            @RequestParam("dietImage") MultipartFile multipartFile,
//            @RequestParam int id,
//            UserExerciseAndDietDTO userExerciseAndDietDTO,
//            Model model,
//            HttpSession httpSession) throws IOException {
//
//        System.out.println("================ onUpdate in controller ==============");
//        System.out.println("ID: " + id);
//        System.out.println("DTO: " + userExerciseAndDietDTO);
//
//        String filePath = null;
//
//        // Check if the uploaded file is empty
//        if (!multipartFile.isEmpty()) {
//            System.out.println("File: " + multipartFile);
//            System.out.println("Original Filename: " + multipartFile.getOriginalFilename());
//
//            // Handle file upload
//            try {
//                byte[] bytes = multipartFile.getBytes();
//
//                // Ensure the parent directory exists
//                Path directoryPath = Paths.get(ProfileImagePath.ProfileImagePath.getPath());
//                if (!Files.exists(directoryPath)) {
//                    Files.createDirectories(directoryPath); // Create directories if they don't exist
//                }
//
//                // Create a unique file path
//                Path path = Paths.get(ProfileImagePath.ProfileImagePath.getPath(), System.currentTimeMillis() + ".jpg");
//                Files.write(path, bytes);
//                filePath = path.getFileName().toString();
//            } catch (IOException e) {
//                e.printStackTrace();
//                model.addAttribute("error", "Failed to upload the file. Please try again.");
//                return "ExerciseAndDiet";
//            }
//        } else {
//            model.addAttribute("error", "File is empty. Please upload a valid image.");
//            return "ExerciseAndDiet";
//        }
//
//        System.out.println("File Path: " + filePath);
//
//        // Save the data using the service layer
//        gymService.saveUserDietAndExercise(id, filePath, userExerciseAndDietDTO);
//
//        // Retrieve data for the model
//        List<RegistrationEntity> registeredUsers = gymService.getAllRegistredUsersDetails();
//        AdminEntity adminEntity = (AdminEntity) httpSession.getAttribute("adminEntity");
//        if (adminEntity == null) {
//            model.addAttribute("error", "Admin session not found. Please log in again.");
//            return "index"; // Redirect to login if admin session is missing
//        }
//
//        // Populate the model
//        model.addAttribute("listimg", adminEntity);
//        model.addAttribute("list", registeredUsers);
//        model.addAttribute("success", "Successfully Updated Exercise and Diet Plan");
//
//        return "UpdateUserExerciseAndDiet";
//    }
//


    @PostMapping("/exercisediet")
    public String onupdate(@RequestParam("dietImage") MultipartFile multipartFile, @RequestParam int id, UserExerciseAndDietDTO userExerciseAndDietDTO , Model model, HttpSession httpSession) throws IOException {
        System.out.println("================onupdate in controller==============");
        System.out.println(id);
        System.out.println(userExerciseAndDietDTO);
        String filePath;

        if (multipartFile.isEmpty()) {
            return "ExerciseAndDiet";
        } else {
            System.out.println(multipartFile);
            System.out.println(multipartFile.getOriginalFilename());
            byte[] bytes = multipartFile.getBytes();

            Path path = Paths.get(ProfileImagePath.ProfileImagePath.getPath() + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            filePath = path.getFileName().toString();
        }
        System.out.println(filePath);
        gymService.saveUserDietAndExercise(id,filePath,userExerciseAndDietDTO);

        List<RegistrationEntity> list=gymService.getAllRegistredUsersDetails();
        AdminEntity adminEntity=(AdminEntity) httpSession.getAttribute("adminEntity");
        model.addAttribute("listimg",adminEntity);
        model.addAttribute("list",list);
        model.addAttribute("success", "Successfully Updated Exercise and Diet Plan");
        return "UpdateUserExerciseAndDiet";
    }

    @GetMapping("/viewUserExercise")
    public String onupdate(@RequestParam int id, HttpSession httpSession, Model model){
        System.out.println(id);
        List<UserUpdatedExerciseAndDietEntity> userExerciseAndDietEntities =gymService.getAlluserExerciseAndDietEntitiesById(id);
        System.out.println(userExerciseAndDietEntities);

        List<UserExerciseAndDietEntity> userMonthlyImages =gymService.getuserMonthlyImages(id);
        model.addAttribute("viewUserExercise",userExerciseAndDietEntities);
        model.addAttribute("monthlyImages",userMonthlyImages);

        AdminEntity adminEntity=(AdminEntity) httpSession.getAttribute("adminEntity");
        model.addAttribute("listimg",adminEntity);
        return "ViewExerciseAndDiet";
    }

}

