package com.xworkz.Sohita_Gym.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class RegistrationDTO {

    @NotNull
    @Size(min = 2,max = 15,message = "Name size must be between 2 to 15 characters")
    private String name;
    @NotNull
    @Max(18)
    @Min(45)
    private int age;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Digits(integer= 10 ,fraction = 0,message = "Number should contain 10 digits")
    private long phoneNo;
    //private String password;
    @NotNull
    @Size(min = 5, max = 25,message = "GymName size must be between 5 to 25 characters")
    private String gymName;
    private String packageType;
    @NotNull
    @Size(min = 3, max = 20,message ="TrainerName size must be between 3 to 20 characters")
    private String trainerName;
    @NotNull
    private double amount;
    @NotNull
    private double amountPaid;
    @NotNull
    private String discount;
    @NotNull
    private int installment;
    @NotNull
    private double balance;
  //  private String filePath;
    @NotNull
    private int height;
    @NotNull
    private int weight;



}