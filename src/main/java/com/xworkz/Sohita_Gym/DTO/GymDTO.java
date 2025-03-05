package com.xworkz.Sohita_Gym.DTO;

import com.xworkz.Sohita_Gym.AbstractAuditEntity.AdminAbstractAuditEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor

public class GymDTO {

    private int id;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;

}
