package com.xworkz.Sohita_Gym.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateRegistrationDTO {

    private int id;
    private String name;
    private long phoneNo;
    private String packageType;
    private String trainerName;
    private int amount;
    private int balance;
}

