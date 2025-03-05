package com.xworkz.Sohita_Gym.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name="assignTrainerToUser")
@Entity
public class AssignTrainersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name= "name")
    private String name;
    @Column(name= "trainerName")
    private String trainerName;
    @Column(name= "slotTimings")
    private String slotTimings;
}
