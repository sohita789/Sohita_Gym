//package com.xworkz.Sohita_Gym.Entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Data
//@NoArgsConstructor
//@Entity
//
//@NamedQuery(name = "getAllRegUpdatedDetailsById",query = "select a from UpdatedRegistrationDetailsEntity a where a.id=:getId")
//public class UpdateRegistrationDetailsEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id_update;
//    private double amount;
//    private double balance;
//    private String packageType;
//    private String trainerName;
//    private LocalDateTime updated_date=LocalDateTime.now();
//    private String updated_by;
//    private int id;
//}
