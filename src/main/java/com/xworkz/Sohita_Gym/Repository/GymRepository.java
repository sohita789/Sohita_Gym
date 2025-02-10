package com.xworkz.Sohita_Gym.Repository;

import com.xworkz.Sohita_Gym.DTO.RegistrationDTO;
import com.xworkz.Sohita_Gym.Entity.*;
//import com.xworkz.Sohita_Gym.Entity.UserLoginEntity;
//import com.xworkz.Sohita_Gym.Entity.UpdateRegistrationDetailsEntity;


import java.util.List;

public interface GymRepository {

    boolean getNameByEmail(String email, String password);

    boolean saveEnquiry(EnquiryEntity enquiryEntity);
    boolean updateStatusAndReason(String name, String status, String reasons);

    List<EnquiryEntity> findByStatus(String status);
    List<EnquiryEntity> findAll();

    boolean saveRegister(RegistrationEntity registrationEntity);
    RegistrationEntity findByNameAndPhoneNo(String name, long phoneNo);

    long countName(String name);
    long countAge(String age);
    long countEmail(String email);
    long countPhoneNo(String phoneNo);
    long countGymName(String gymName);
    long countTrainerName(String trainerName);
    long countAmount(String amount);
    long countAmountPaid(String amountPaid);
    long countInstallment(String installment);
    long countBalance(String balance);
    long countPassword(String password);

    List<ViewEnqDetailsEntity> getAllData(int enquiryId);
    boolean saveView(ViewEnqDetailsEntity viewEnqDetailsEntity);

    EnquiryEntity getEnquiryEntityByName(String name);
   // public boolean updateUserdetails(RegistrationEntity entity);
  //  RegistrationEntity findregistrationbyid(int registrationId);

    //userLogin
    RegistrationEntity userSave(String email);
    void updateCount(String email, int count);
//    String updateAccountLockTimeByEmail(String email);
    boolean resetCount(String email, int count);

    String updateAccountLockTimeByEmail(String email);

    RegistrationEntity updateRegistration(String name, long phoneNo);
    String updatePasswordByName(String newPassword, String name);
    String resetPasswordByEmail(String email, String newPassword);

    Long getCountOfAdminUserNameByEmail(String email);
    Long getCountOfAdminUserNameByPassword(String password);

    //slot
    public boolean saveSlots(SlotTimingsEntity slotTimings);
    List<SlotTimingsEntity> findallslots();

    //traianer slot
    boolean savetrainerdetails(TrainerinfoEntity entity);

    List<TrainerinfoEntity> findAlltrainerlist();

    List<RegistrationEntity> getAllRegisteredUserDetailsById(int id);

    RegistrationDTO updateUserProfile(String name, RegistrationDTO registrationDTO, String filePath);

   public boolean getDeleteTrainersById(int id);

}





