package com.xworkz.Sohita_Gym.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "userexerciseanddiet_table")
@Data
@NamedQuery(name = "getuserMonthlyImages",query = "select a from UserExerciseAndDietEntity a where a.id=:getId")
public class UserExerciseAndDietEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int User_id;

    @Column(name = "monday")
    private String monday;
    @Column(name = "tuesday")
    private String tuesday;
    @Column(name = "wednesday")
    private String wednesday;
    @Column(name = "thursday")
    private String thursday;
    @Column(name = "friday")
    private String friday;
    @Column(name ="saturday")
    private String saturday;
    @Column(name = "sunday")
    private String sunday;
    @Column(name = "month")
    private String month;
    @Column(name = "diet_plan")
    private String dietPlan;
    @Column(name = "monthly_image")
    private String usermonthlyImage;

    private int id;
//    @ManyToOne
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    private UserUpdatedExerciseAndDietEntity userUpdatedExerciseAndDietEntity;
}

