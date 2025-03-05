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

    // Get all the ViewEnquiryDetails \\
    List<ViewEnqDetailsEntity> getAllData(int enquiryId);

    // Save The ViewEnquiryDetails \\
    boolean saveView(ViewEnqDetailsEntity viewEnqDetailsEntity);

    // Get EnquiryDetails By Name \\
    EnquiryEntity getEnquiryEntityByName(String name);


    //userLogin
    RegistrationEntity userSave(String email);
    void updateCount(String email, int count);

    boolean resetCount(String email, int count);

    // AccountLock Time\\
    String updateAccountLockTimeByEmail(String email);

    // Update the Registration details\\
    RegistrationEntity updateRegistration(String name, long phoneNo);
    String updatePasswordByName(String newPassword, String name);
    String resetPasswordByEmail(String email, String newPassword);

    Long getCountOfAdminUserNameByEmail(String email);
    Long getCountOfAdminUserNameByPassword(String password);

    //save the slot timings\\
    public boolean saveSlots(SlotTimingsEntity slotTimings);
    // get All The Slots\\
    List<SlotTimingsEntity> findallslots();

    //Save TrainerDetails//
    boolean savetrainerdetails(TrainerinfoEntity entity);

    // Get all TrainersList\\
    List<TrainerinfoEntity> findAlltrainerlist();

    // Get the userDetails By id\\
    List<RegistrationEntity> getAllRegisteredUserDetailsById(int id);

    RegistrationDTO updateUserProfile(String name, RegistrationDTO registrationDTO, String filePath);

    public boolean getDeleteTrainersById(int id);

    RegistrationEntity findByEmailCustom(String email);

    boolean updateValuesById(String packageType, String trainerName, double amount, double amountPaid, double balance, int installment, int id);


    // Get All TRhe Registration Details\\
    List<RegistrationEntity> getAllDetails();

     // Get the TrainerDetails\\
    List<TrainerinfoEntity> getTrainerDetails();

    // Get The TrainerData By id\\
    TrainerinfoEntity getDataByTrainerId(int id);

    // Update The TrainerEntity \\
    boolean updateTrainerEntity(TrainerinfoEntity entity);

    // Save The TrainerAssign Details\\
    boolean saveTrainerAssignDetails(AssignTrainersEntity assignTrainersEntity);

    //fetching all names from EnquiryEntity in register
    List<EnquiryEntity> getAllEnquiry();

    String getPhoneNumberByName(String name);

    ///////////////////////////////////
    List<RegistrationEntity> getAllRegistredUsersDetails();
    List<RegistrationEntity> getAllRegistredUsersDetailsByNameAndPhoneNo(String searchName, Long searchPhoneNo);


    void saveUserDietAndExercise(UserExerciseAndDietEntity entity);
    List<UserUpdatedExerciseAndDietEntity> getAlluserExerciseAndDietEntitiesById(int id);
    void saveUserUpdatedDietAndExercise(UserUpdatedExerciseAndDietEntity entity);
    List<UserExerciseAndDietEntity> getuserMonthlyImages(int id);

}






