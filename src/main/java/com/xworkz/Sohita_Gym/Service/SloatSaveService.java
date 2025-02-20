//package com.xworkz.Sohita_Gym.Service;
//
//import com.xworkz.Sohita_Gym.DTO.SlotDTO;
//import com.xworkz.Sohita_Gym.DTO.TrainerTimeAllotment;
//import com.xworkz.Sohita_Gym.Entity.SlotEntity;
//import com.xworkz.Sohita_Gym.Entity.TrainerTimeAllotmentEntity;
//
//import java.time.Duration;
//import java.time.LocalTime;
//import java.util.List;
//
//public interface SloatSaveService {
//
//
//    Duration timeDuration(LocalTime startTime, LocalTime endTime);
//
//    boolean onSave(SlotDTO dto);
//
//    List<SlotEntity> getSlots();
//
//    boolean trainerAllotment(TrainerTimeAllotment dto);
//
//    List<TrainerTimeAllotmentEntity> getDetails();
//
//    boolean deleteTrsiner(int id);
//
//    String getTrainerSlot(String trainerSlot);
//
//}
