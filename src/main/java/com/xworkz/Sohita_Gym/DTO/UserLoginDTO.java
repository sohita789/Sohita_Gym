package com.xworkz.Sohita_Gym.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class UserLoginDTO {

    private int id;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}