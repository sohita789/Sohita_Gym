package com.xworkz.Sohita_Gym.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "registration_table")
@NoArgsConstructor
//@NamedQuery(name = "getAllRegUpdatedDetailsById",query = "select a from UpdatedRegistrationDetailsEntity a where a.id=:getId")
public class UpdateRegistrationEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private long phoneNo;

    private String packageType;

    private String trainerName;

    private double amount;

    private double balance;
}

