package com.xworkz.Sohita_Gym.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@Entity
@RequiredArgsConstructor
@Table(name = "registration_table")


@NamedQuery(name = "getRegistrationEntitycountName", query = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.name = :name")
@NamedQuery(name = "getRegistrationEntitycountAge", query = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.age = : age")
@NamedQuery(name = "getRegistrationEntitycountEmail", query = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.email = :email")
@NamedQuery(name = "getRegistrationEntitycountPhoneNo", query = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.phoneNo = :phoneNo")
//@NamedQuery(name = "getRegistrationEntitycountPassword", query ="SELECT COUNT(p) FROM RegistrationEntity p WHERE p.password =:password")
@NamedQuery(name = "getRegistrationEntitycountGymName", query = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.gymName = :gymName")
@NamedQuery(name = "getRegistrationEntitycountTrainerName", query = "SELECT COUNT(p) FROM RegistrationEntity p WHERE p.trainerName =:trainerName")
//USer login and count
@NamedQuery(name = "getAllByEmail", query="select re from RegistrationEntity re  where re.email = :byEmail")
@NamedQuery(name = "updateCount",query="update RegistrationEntity re set re.count = :setCount where re.email = :byEmail")
@NamedQuery(name = "resetCount",query="update RegistrationEntity re set re.count = :setCount where re.email = :byEmail")
//count
@NamedQuery(name = "updatePasswordByName",query = "update RegistrationEntity re set re.password = :setNewPassword , re.count = :setCount where re.name = :nameBy")
//forget password
@NamedQuery(name = "resetPasswordByEmail", query = "update RegistrationEntity re set re.password = :setNewPassword where re.email = :emailBy")


public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private long phoneNo;
    private String password;
    private String gymName;
    private String packageType;
    private String trainerName;
    private double amount;
    private double amountPaid;
    private String discount;
    private int installment;
    private double balance;
    private int count;
    private LocalDateTime accountLockedTime = LocalDateTime.now();
//    @Column(name = "profile_image")
//    private String profileImage;
//
}



