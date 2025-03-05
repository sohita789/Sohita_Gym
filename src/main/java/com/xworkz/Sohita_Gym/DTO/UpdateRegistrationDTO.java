package com.xworkz.Sohita_Gym.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UpdateRegistrationDTO {

    private int id;
    @NotNull
    @Size(min = 2,max = 15,message = "Name size must be between 2 to 15 characters")
    private String name;
    @NotNull
    @Digits(integer= 10 ,fraction = 0,message = "Phone Number Must Be 10 digits")
    private long phoneNo;
    @NotNull
    private String packageType;
    @NotNull
    @Size(min = 3,max = 15,message = "Name size must be between 3 to 15 characters")
    private String trainerName;
    @NotNull
    private int amount;
    @NotNull
    private int balance;
    @NotNull
    private int amountPaid;
}

