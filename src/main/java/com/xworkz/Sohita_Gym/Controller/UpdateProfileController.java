package com.xworkz.Sohita_Gym.Controller;

import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
import com.xworkz.Sohita_Gym.Entity.AdminEntity;
import com.xworkz.Sohita_Gym.Entity.RegistrationEntity;
import com.xworkz.Sohita_Gym.Service.GymService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/")
@Slf4j

public class UpdateProfileController {

    @Autowired
    private GymService gymService;

    @GetMapping("/update")
    public String onUpdateProfile(@RequestParam int id, Model model) {
        System.out.println("=============================update action+++========");
        RegistrationEntity entity1 = new RegistrationEntity();
        System.out.println("id is coming" + id);
        if (id <= 0) {
            model.addAttribute("error", "Invalid user Id");
            return "ErrorPage";
        }

        List<RegistrationEntity> entities = gymService.getAllRegisteredUserDetailsById(id);
        if(entities != null && !entities.isEmpty()) {
            RegistrationEntity entity = entities.get(0);
            model.addAttribute("register", entity);
            model.addAttribute("filePath", entity.getFilePath());
        }else {
            model.addAttribute("error", "No user found for this id");
            return "ErrorPage";
        }
        return "UpdateUserProfile";

        }

        @GetMapping("/download")
    public void display(HttpServletResponse response, @RequestParam String filePath) throws  Exception{
        System.out.println("this is image"+filePath);
        response.setContentType("Image/jpg");
        File file = new File("C:\\ProfileImagePath\\" + filePath);
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream = response.getOutputStream();
        IOUtils.copy(inputStream, outputStream);
        response.flushBuffer();
    }


    @PostMapping("/updateUserProfile")
    public String onUpdating(@RequestParam String name, RegistrationDTO registrationDTO, @RequestParam("picture") MultipartFile multipartFile, Model model) throws IOException {
        System.out.println(name);

        if (multipartFile.isEmpty()) {
            // Add the name to the model to pass it to the Success page
            RegistrationDTO dto = gymService.updateUserProfile(name, registrationDTO,null);
            model.addAttribute("register", name);
            return "Success";

        }else{
            System.out.println("multipartFile="+multipartFile);
            System.out.println("multipartFile OriginalFileName=="+multipartFile.getOriginalFilename());
            System.out.println("multipartFile=="+multipartFile.getContentType());

            byte[] bytes = multipartFile.getBytes();
            Path path = Paths.get("C:\\ProfileImagePath\\" + name + System.currentTimeMillis() + ".jpg");
            Files.write(path, bytes);
            String filePath = path.getFileName().toString();
            System.err.println("filePath=====" + filePath);

            RegistrationDTO dto = gymService.updateUserProfile(name, registrationDTO,filePath);
            return "UserProfile";
        }
    }
}

