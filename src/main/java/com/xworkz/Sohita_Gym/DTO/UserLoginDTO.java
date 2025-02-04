package com.xworkz.Sohita_Gym.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserLoginDTO {

    private int id;
    private String email;
    private String password;
}