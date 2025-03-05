package com.xworkz.Sohita_Gym.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "trainerslot_table")
@NamedQuery(name = "GetslotList", query = "SELECT e FROM SlotTimingsEntity e")

public class SlotTimingsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "startTimings")
    private String startTimings;

    @Column(name = "endTimings")
    private String endTimings;

    @Column(name = "duration")
    private String duration;
}
