package com.xworkz.Sohita_Gym.Entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@Table(name="trainerinfo_table")

//@Table(name = "trainerinfo")
@NamedQuery(name = "GetTrainerInfoList", query = "SELECT e FROM TrainerinfoEntity e")

public class TrainerinfoEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "Name")
        private String name;

        @Column(name = "PhoneNumber")
        private String phoneNumber;

        @Column(name = "SlotTimings")
        private String slotTimings;
}
