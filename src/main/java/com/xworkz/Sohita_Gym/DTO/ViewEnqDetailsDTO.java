package com.xworkz.Sohita_Gym.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor

public class ViewEnqDetailsDTO {

    private int viewId;
    @NotNull
    @Size(min = 2,max = 15,message = "Name size must be between 2 to 15 characters")
    private String name;
    @NotNull
    @Size(min = 10,max = 70,message = "Name size must be between 10 to 70 characters")
    private String area;
    @NotNull
    @Digits(integer= 10 ,fraction = 0,message = "Phone Number Must Be 10 digits")
    private long phoneNo;
    @NotNull
    @Size(min = 5,max = 30,message = "Reasons size must be between 5 to 30 characters")
    private String Reasons;
}
