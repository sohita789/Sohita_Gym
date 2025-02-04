package com.xworkz.Sohita_Gym.DTO;

import com.xworkz.Sohita_Gym.AbstractAuditEntity.AdminAbstractAuditEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
public class EnquiryDTO extends AdminAbstractAuditEntity {

    private int enquiryId;
    @NotNull
    @Size(min = 2,max = 15,message = "Name size must be between 2 to 15 characters")
    private String name;
    @NotNull
    @Max(18)
    @Min(45)
    private int age;
    @NotNull
    private int distance;
    @NotNull
    @Size(min = 5,max = 15,message = "Name size must be between 5 to 25 characters")
    private String area;
    @NotNull
    @Digits(integer= 10 ,fraction = 0,message = "Number should contain 10 digits")
    private long phoneNo;

}

