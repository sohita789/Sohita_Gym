package com.xworkz.Sohita_Gym.Service;

import com.xworkz.Sohita_Gym.DTO.EnquiryDTO;
import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
//import com.xworkz.Sohita_Gym.DTO.UserLoginDTO;
import com.xworkz.Sohita_Gym.DTO.ViewEnqDetailsDTO;
import com.xworkz.Sohita_Gym.Entity.*;
//import com.xworkz.Sohita_Gym.Entity.UserLoginEntity;
import java.util.List;

public interface GymService {

    //Admin Login
    boolean getNameByEmail(String email, String password);

    Long getCountOfAdminUserNameByEmail(String email);

    Long getCountOfAdminUserNameByPassword(String password);

    //Enquiry
    boolean saveEnquiry(EnquiryDTO enquiryDTO);

    //Update Enquiry
    boolean updateStatusAndReason(String name, String status, String reasons);

    //Enquiry
    List<EnquiryEntity> getEnquiriesByStatus(String status);

    List<EnquiryEntity> getEnquiries();

    //Register
    boolean saveRegister(RegistrationDTO registrationDTO);

    boolean updateRegister(RegistrationDTO dto, String name, long phoneNo);

    long countName(String name);

    long countAge(String age);

    long countEmail(String email);

    long countPhoneNo(String phoneNo);

    long countPassword(String password);

    long countGymName(String gymName);

    long countTrainerName(String trainerName);

    //email
    public boolean saveEmail(String email, String password);

    long countAmount(String amount);

    long countAmountPaid(String amountPaid);

    long countInstallment(String installment);

    long countBalance(String balance);

    //ViewDetails
    boolean saveView(ViewEnqDetailsDTO viewEnqDetailsDTO);

    List<ViewEnqDetailsEntity> getAllData(int enquiryId);

    //UserLogin
    RegistrationEntity userSave(String email, String password);

    //reset password
    String updatePasswordByName(String name, String oldPassword, String newPassword, String confirmPassword);

    //forget password
    String resetPasswordByEmail(String email, String newPassword, String confirmPassword);

    //slots
    public boolean saveSlots(String startTimings, String endTimings, String duration);
    public List<SlotTimingsEntity> getAllslots();

    // trainerdetails
    public boolean savetrainerdetails(String name, String phoneNumber, String slotTimings);
    public List<TrainerinfoEntity> getAlltrainerdetails();

    //Update Profile
    List<RegistrationEntity> getAllRegisteredUserDetailsById(int id);
    RegistrationDTO updateUserProfile(String name,RegistrationDTO registrationDTO, String filePath);

    boolean getDeleteTrainersById(int id);
}