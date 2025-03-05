package com.xworkz.Sohita_Gym.Service;

import com.xworkz.Sohita_Gym.Constants.StatusEnum;
import com.xworkz.Sohita_Gym.DTO.*;


import com.xworkz.Sohita_Gym.Entity.*;
import com.xworkz.Sohita_Gym.Repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;

@Service
public class GymServiceImplementation implements GymService {

    public String generatedPassword;

    @Autowired
    GymRepository gymRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @Override
    public boolean getNameByEmail(String email, String password) {
        System.out.println("get The name by email and password in GymServiceImplementation");
        boolean getName = gymRepository.getNameByEmail(email, password);
        return getName;
    }

    @Override
    public Long getCountOfAdminUserNameByEmail(String email) {
        return gymRepository.getCountOfAdminUserNameByEmail(email);
    }

    @Override
    public Long getCountOfAdminUserNameByPassword(String password) {
        return gymRepository.getCountOfAdminUserNameByPassword(password);
    }

    @Override
    public boolean saveEnquiry(EnquiryDTO enquiryDTO) {
        System.out.println("saveEnquiry method in gymServiceImplementation");
        EnquiryEntity enquiryEntity = new EnquiryEntity();
        enquiryEntity.setName(enquiryDTO.getName());
        enquiryEntity.setAge(enquiryDTO.getAge());
        enquiryEntity.setArea(enquiryDTO.getArea());
        enquiryEntity.setPhoneNo(enquiryDTO.getPhoneNo());
        enquiryEntity.setDistance(enquiryDTO.getDistance());
        enquiryEntity.setStatus(String.valueOf(StatusEnum.Enquired));
        enquiryEntity.setCreatedBy(enquiryDTO.getCreatedBy());
        enquiryEntity.setUpdatedBy(enquiryDTO.getUpdatedBy());

        boolean savedEnquiry = gymRepository.saveEnquiry(enquiryEntity);
        if (savedEnquiry) {
            System.out.println("Enquiry details is saved to Database");
            return true;
        } else {
            System.out.println("EnquiryDetails is not saved to DataBase");
            return false;
        }
    }

    @Override
    public boolean updateStatusAndReason(String name, String status, String reasons) {
        System.out.println("updateStatusAndReason in GymServiceImpl");
        boolean saved = gymRepository.updateStatusAndReason(name, status, reasons);
        EnquiryEntity enquiryEntity = gymRepository.getEnquiryEntityByName(name);
        ViewEnqDetailsEntity viewEnqDetailsEntity = new ViewEnqDetailsEntity();
        viewEnqDetailsEntity.setName(enquiryEntity.getName());
        viewEnqDetailsEntity.setArea(enquiryEntity.getArea());
        viewEnqDetailsEntity.setPhoneNo(enquiryEntity.getPhoneNo());
        viewEnqDetailsEntity.setReasons(enquiryEntity.getReasons());
        viewEnqDetailsEntity.setEnquiryEntity(enquiryEntity);

        gymRepository.saveView(viewEnqDetailsEntity);
        if (saved)
            return true;
        return false;
    }


    @Override
    public List<EnquiryEntity> getEnquiriesByStatus(String status) {
        return gymRepository.findByStatus(status);
    }

    @Override
    public List<EnquiryEntity> getEnquiries() {
        return gymRepository.findAll();
    }

    @Override
    public boolean saveRegister(RegistrationDTO registrationDTO) {
        System.out.println("saveRegister method in GymServiceImplementation");
        RegistrationEntity registrationEntity = new RegistrationEntity();
        registrationEntity.setName(registrationDTO.getName());
        registrationEntity.setAge(registrationDTO.getAge());
        registrationEntity.setEmail(registrationDTO.getEmail());
        registrationEntity.setPhoneNo(registrationDTO.getPhoneNo());
        registrationEntity.setPassword(generatedPassword);
        registrationEntity.setGymName(registrationDTO.getGymName());
        registrationEntity.setPackageType(registrationDTO.getPackageType());
        registrationEntity.setTrainerName(registrationDTO.getTrainerName());
        registrationEntity.setAmount(registrationDTO.getAmount());
        registrationEntity.setAmountPaid(registrationDTO.getAmountPaid());
        registrationEntity.setDiscount(registrationDTO.getDiscount());
        registrationEntity.setInstallment(registrationDTO.getInstallment());
        registrationEntity.setBalance(registrationDTO.getBalance());
        registrationEntity.setCount(-1);

        String randomPassword = generateRandomPassword();
        registrationEntity.setPassword(randomPassword);

        boolean savedRegister = gymRepository.saveRegister(registrationEntity);
        if (savedRegister) {
            System.out.println("Registration details saved To Database");
            saveEmail(registrationDTO.getEmail(), randomPassword);
        }
        System.out.println(" Registration Details is not saved to DataBase");
        return savedRegister;
    }

    public static String generateRandomPassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        int length = 6;

        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    @Override
    public boolean updateRegister(RegistrationDTO dto, String name, long phoneNo) {
        RegistrationEntity entity = gymRepository.updateRegistration(name, phoneNo);
        if (entity != null) {
            entity.setPackageType(dto.getPackageType());
            entity.setTrainerName(dto.getTrainerName());
            entity.setAmount(dto.getAmount());
            entity.setBalance(dto.getBalance());

            // Save the updated entity back to the database
            gymRepository.saveRegister(entity);
            return true; // Successfully updated
        }
        return false;

    }

    @Override
    public long countName(String name) {
        Long count = gymRepository.countName(name);
        return count;
    }

    @Override
    public long countAge(String age) {
        Long count = gymRepository.countAge(age);
        return gymRepository.countAge(age);
    }

    @Override
    public long countEmail(String email) {
        return gymRepository.countEmail(email);
    }

    @Override
    public long countPhoneNo(String phoneNo) {
        return gymRepository.countPhoneNo(phoneNo);
    }

    @Override
    public long countPassword(String password) {
        return gymRepository.countPassword(password);

    }

    @Override
    public long countGymName(String gymName) {
        return gymRepository.countGymName(gymName);
    }

    @Override
    public long countTrainerName(String trainerName) {
        return gymRepository.countTrainerName(trainerName);
    }

    @Override
    public boolean saveEmail(String email, String password) {
        System.out.println(email + password);
        final String username = "sohitapatil217@gmail.com";
        final String userPassword = "mgiz lnbj tfmj caww";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("Email sent SuccessFully");
        Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, userPassword);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your password");
            message.setText("your password : " + generatedPassword);

            message.setSubject("Registration Success");

            String emailContent = "<html><body>"
                    + "<h2>Dear " + username + ",</h2>"
                    + "<p>Thank you for your Registration</p>"
                    + "<p>Your Password is " + generatedPassword + "</p>"
                    + "</body></html>";
            message.setContent(emailContent, "text/html");
            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
        return true;
    }


    @Override
    public long countAmount(String amount) {
        return gymRepository.countAmount(amount);
    }

    @Override
    public long countAmountPaid(String amountPaid) {
        return gymRepository.countAmountPaid(amountPaid);
    }

    @Override
    public long countInstallment(String installment) {
        return gymRepository.countInstallment(installment);
    }

    @Override
    public long countBalance(String balance) {
        return gymRepository.countBalance(balance);
    }

    @Override
    public boolean saveView(ViewEnqDetailsDTO viewEnqDetailsDTO) {
        System.out.println("saveview in serviceImpl");
        ViewEnqDetailsEntity entity = new ViewEnqDetailsEntity();
        boolean savedView = gymRepository.saveView(entity);
        if (savedView) {
            System.out.println("saved view page in service");
            return true;
        } else {
            System.out.println(" saveView is not saved");
            return false;
        }
    }

    @Override
    public List<ViewEnqDetailsEntity> getAllData(int enquiryId) {
        System.out.println("viewDetails in service ==" + gymRepository.getAllData(enquiryId));
        return gymRepository.getAllData(enquiryId);
    }

    @Override
    public RegistrationEntity userSave(String email, String password) {
        RegistrationEntity registrationEntity = gymRepository.userSave(email);
        if (registrationEntity != null) {
            System.out.println(registrationEntity.toString());
            if (password.equals(registrationEntity.getPassword()) && registrationEntity.getCount() == -1) {
                System.out.println("Password matches");
                return registrationEntity;

            } else if (!(password.equals(registrationEntity.getPassword())) && (registrationEntity.getCount() >= 0 && registrationEntity.getCount() < 3)) {
                gymRepository.updateCount(email, registrationEntity.getCount());
                System.out.println("Wrong password");
                return null;

            } else if (!(password.equals(registrationEntity.getPassword())) && registrationEntity.getCount() == 3) {
                System.out.println("Account Locked");
                if (registrationEntity.getAccountLockedTime() == null)
                    gymRepository.updateAccountLockTimeByEmail(email);
                return null;

            } else if (password.equals(registrationEntity.getPassword()) && (registrationEntity.getCount() < 3 && registrationEntity.getCount() > -1)) {
                boolean reset = gymRepository.resetCount(email, registrationEntity.getCount());
                if (reset)
                    return registrationEntity;
                else {
                    return null;
                }
            }
            return null;
        }
        return registrationEntity;
    }

    @Override
    public String updatePasswordByName(String name, String oldPassword, String newPassword, String confirmPassword) {
        if (newPassword.equals(confirmPassword)) {
            String msg = gymRepository.updatePasswordByName(newPassword, name);
        }
        return "password updated successfully";
    }


    @Override
    public String resetPasswordByEmail(String email, String newPassword, String confirmPassword) {
        System.out.println("reset password in service");
        if (newPassword.equals(confirmPassword)) {
            gymRepository.userSave(email);
            return gymRepository.resetPasswordByEmail(email, newPassword);
        }
        return "password reset successfully";

    }

    @Override
    public boolean saveSlots(String startTimings, String endTimings, String duration) {
        SlotTimingsEntity entity = new SlotTimingsEntity();
        entity.setStartTimings(startTimings);
        entity.setEndTimings(endTimings);
        entity.setDuration(duration);
        return gymRepository.saveSlots(entity);
    }

    @Override
    public List<SlotTimingsEntity> getAllslots() {
        return gymRepository.findallslots();
    }

    @Override
    public boolean savetrainerdetails(String trainerName, String phoneNumber, String slotTimings) {

        TrainerinfoEntity entity = new TrainerinfoEntity();
        entity.setTrainerName(trainerName);
        entity.setPhoneNumber(phoneNumber);
        entity.setSlotTimings(slotTimings);
        return gymRepository.savetrainerdetails(entity);
    }

    @Override
    public List<TrainerinfoEntity> getAlltrainerdetails() {
        return gymRepository.findAlltrainerlist();
    }

    @Override
    public List<RegistrationEntity> getAllRegisteredUserDetailsById(int id) {
        return gymRepository.getAllRegisteredUserDetailsById(id);
    }


    @Override
    public RegistrationDTO updateUserProfile(String name, RegistrationDTO registrationDTO, String filePath) {
        return gymRepository.updateUserProfile(name, registrationDTO, filePath);
    }

    @Override
    public boolean getDeleteTrainersById(int id) {
        return gymRepository.getDeleteTrainersById(id);
    }


    //update
    @Override
    public RegistrationEntity getDetailsByEmail(String email) {
        return gymRepository.findByEmailCustom(email);

    }

    @Override
    public boolean updateDetailsById(String packageType, String trainerName, double amount, double amountPaid, double balance, int installment, int id) {
        gymRepository.updateValuesById(packageType, trainerName, amount, amountPaid, balance, installment, id);
        return true;
    }

    @Override
    public boolean saveTrainerAssignDetails(AssignTrainerDTO assignTrainerDTO) {
//        System.out.println("save assign trainer in serviceImpl");
//        AssignTrainersEntity entity = new AssignTrainersEntity();
//        entity.setName(assignTrainerDTO.getName());
//        entity.setTrainerName(assignTrainerDTO.getTrainerName());
//        entity.setSlotTimings(assignTrainerDTO.getSlotTimings());
//
//        boolean saved = gymRepository.saveTrainerAssignDetails(entity);
//        if(saved){
//            System.out.println("saved in serviceImpl");
//            return true;
//        }
//        System.out.println("not saved in serviceImpl");
//        return false;

        System.out.println("save assign trainer in serviceImpl");
        AssignTrainersEntity entity = new AssignTrainersEntity();
        entity.setName(assignTrainerDTO.getName());
        entity.setTrainerName(assignTrainerDTO.getTrainerName());
        entity.setSlotTimings(assignTrainerDTO.getSlotTimings());

        try {
            boolean saved = gymRepository.saveTrainerAssignDetails(entity);
            if (saved) {
                System.out.println("saved in serviceImpl");
                return true;
            }
        } catch (Exception e) {
            System.err.println("Error occurred while saving trainer assignment details: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("not saved in serviceImpl");
        return false;
    }


    @Override
    public List<RegistrationEntity> getAllDetails() {
        System.out.println("----------------------get alla details in ServiceImpl- --------------");
        if ((gymRepository.getAllDetails() != null)) {
            return gymRepository.getAllDetails();
        }
        return Collections.emptyList();

    }


    @Override
    public List<TrainerinfoEntity> getTrainerDetails() {
        System.out.println("======--------getTrainerDetails in ServiceImpl-------======");
        if ((gymRepository.getTrainerDetails() != null)) {
            return gymRepository.getTrainerDetails();
        }
        return Collections.emptyList();
    }


    @Override
    public TrainerinfoEntity getByIdToAssignTrainer(int id, String trainerName, String slotTimings) {
        TrainerinfoEntity trainerEntity = gymRepository.getDataByTrainerId(id);
        if (trainerEntity != null) {
            trainerEntity.setTrainerName(trainerName);  //setTrainername(trainer);
            gymRepository.updateTrainerEntity(trainerEntity);
            return trainerEntity;
        }
        return null;
    }
    //fetching all names from EnquiryEntity in register
    @Override
    public List<EnquiryEntity> getAllEnquiry() {
        System.out.println("----------------------get all details in ServiceImpl- --------------");
        if((gymRepository.getAllEnquiry()!=null)){
            return gymRepository.getAllEnquiry();
        }
        return Collections.emptyList();
    }

    @Override
    public String getPhoneNumberByName(String name) {
        System.out.println("======getPhoneNumberByName in service=======");
        String num = gymRepository.getPhoneNumberByName(name);
        return num;

    }
    ///   /////////////////////////////////////
    @Override
    public void saveUserDietAndExercise(int id, String filePath, UserExerciseAndDietDTO userExerciseAndDietDTO) {
        UserExerciseAndDietEntity entity=new UserExerciseAndDietEntity();
        entity.setId(id);
        entity.setMonday(userExerciseAndDietDTO.getMonday());
        entity.setTuesday(userExerciseAndDietDTO.getTuesday());
        entity.setWednesday(userExerciseAndDietDTO.getWednesday());
        entity.setThursday(userExerciseAndDietDTO.getThursday());
        entity.setFriday(userExerciseAndDietDTO.getFriday());
        entity.setSaturday(userExerciseAndDietDTO.getSaturday());
        entity.setSunday(userExerciseAndDietDTO.getSunday());
        entity.setMonth(userExerciseAndDietDTO.getMonth());
        entity.setDietPlan(userExerciseAndDietDTO.getDietPlan());
        entity.setUsermonthlyImage(filePath);
        gymRepository.saveUserDietAndExercise(entity);
        UserUpdatedExerciseAndDietEntity userUpdatedExerciseAndDietEntity=new UserUpdatedExerciseAndDietEntity();
        userUpdatedExerciseAndDietEntity.setId(id);
        userUpdatedExerciseAndDietEntity.setMonday(userExerciseAndDietDTO.getMonday());
        userUpdatedExerciseAndDietEntity.setTuesday(userExerciseAndDietDTO.getTuesday());
        userUpdatedExerciseAndDietEntity.setWednesday(userExerciseAndDietDTO.getWednesday());
        userUpdatedExerciseAndDietEntity.setThursday(userExerciseAndDietDTO.getThursday());
        userUpdatedExerciseAndDietEntity.setFriday(userExerciseAndDietDTO.getFriday());
        userUpdatedExerciseAndDietEntity.setSaturday(userExerciseAndDietDTO.getSaturday());
        userUpdatedExerciseAndDietEntity.setSunday(userExerciseAndDietDTO.getSunday());
        userUpdatedExerciseAndDietEntity.setMonth(userExerciseAndDietDTO.getMonth());
        userUpdatedExerciseAndDietEntity.setDietPlan(userExerciseAndDietDTO.getDietPlan());
        userUpdatedExerciseAndDietEntity.setUsermonthlyImage(filePath);
        gymRepository.saveUserUpdatedDietAndExercise(userUpdatedExerciseAndDietEntity);
    }


    @Override
    public List<UserUpdatedExerciseAndDietEntity> getAlluserExerciseAndDietEntitiesById(int id) {
        return gymRepository.getAlluserExerciseAndDietEntitiesById(id);

    }

    @Override
    public List<UserExerciseAndDietEntity> getuserMonthlyImages(int id) {
        return gymRepository.getuserMonthlyImages(id);
    }

    @Override
    public List<RegistrationEntity> getAllRegistredUsersDetails() {
        return gymRepository.getAllRegistredUsersDetails();

    }

    @Override
    public List<RegistrationEntity> getAllRegistredUsersDetailsByNameAndPhoneNo(String searchName, Long searchPhoneNo) {
        return gymRepository.getAllRegistredUsersDetailsByNameAndPhoneNo( searchName, searchPhoneNo);

    }

}









