//package com.xworkz.Sohita_Gym.Entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//
//@Data
//@Entity
//@Table(name = "registration_table")
//@NoArgsConstructor
////@NamedQuery(name = "getAllRegDetailsById",query = "select re from RegistrationEntity re where re.id=:getId")
////@NamedQuery(name = "updateUserProfileByName", query = "UPDATE RegistrationEntity re SET re.age=:getAge,re.height=:getHeight,re.weight=:getWeight,re.filePath=:getFilePath where re.name=:getName")
////@NamedQuery(name = "getAllRegUpdatedDetailsById",query = "select a from UpdatedRegistrationDetailsEntity a where a.id=:getId")
//public class UpdateRegistrationEntity {
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//
//    private String name;
//
//    private long phoneNo;
//
//    private String packageType;
//
//    private String trainerName;
//
//    private double amount;
//
//    private double balance;
//
//    private double amountPaid;
//}
//
