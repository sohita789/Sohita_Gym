package com.xworkz.Sohita_Gym.DTO;

import com.xworkz.Sohita_Gym.AbstractAuditEntity.AdminAbstractAuditEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class GymDTO {

    private int id;
    private String email;
    private String password;

}
