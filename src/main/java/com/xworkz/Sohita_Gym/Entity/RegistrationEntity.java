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
@NamedQuery(name = "getAllRegDetailsById",query = "select re from RegistrationEntity re where re.id=:getId")
@NamedQuery(name = "updateUserProfileByName", query = "UPDATE RegistrationEntity re SET re.age=:getAge,re.height=:getHeight,re.weight=:getWeight,re.filePath=:getFilePath where re.name=:getName")
//update registration details by id
@NamedQuery(name = "updateValuesById", query = "UPDATE RegistrationEntity p SET p.packageType = :setPackageType, p.trainerName = :setTrainerName, p.amount = :setAmount, p.amountPaid = :setPaid, p.balance = :setBalance, p.installment = :setInstallment where p.id = :idBy")

@NamedQuery(name="getAllDetailsOfCustomer", query="select re from RegistrationEntity re")

//for diet
@NamedQuery(name="getAllRegistredUsersDetails", query="select a from RegistrationEntity a")
@NamedQuery(name="getAllRegistredUsersDetailsByNameAndPhoneNo", query="select a from RegistrationEntity a where a.name=:getName and a.phoneNo=:getPhoneNo")
public class RegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name= "age")
    private int age;
    @Column(name= "email")
    private String email;
    @Column(name= "phoneNo")
    private long phoneNo;
    @Column(name= "password")
    private String password;
    @Column(name= "gymName")
    private String gymName;
    @Column(name= "packageType")
    private String packageType;
    @Column(name = "trainerName")
    private String trainerName;
    @Column(name= "amount")
    private double amount;
    @Column(name= "amountpaid")
    private double amountPaid;
    @Column(name= "discount")
    private String discount;
    @Column(name= "installment")
    private int installment;
    @Column(name= "balance")
    private double balance;
    @Column(name= "count")
    private int count;
    private LocalDateTime accountLockedTime;
    //@Column(name = "file_path")
    private String filePath;
    @Column(name= "height")
    private int height;
    @Column(name= "weight")
    private int weight;
}



