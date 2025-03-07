package com.xworkz.Sohita_Gym.Entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Table(name = "UserUpdatedExercise_table")
@Data
@NamedQuery(name = "getAlluserExerciseAndDietEntitiesById",query ="select a from UserUpdatedExerciseAndDietEntity a where a.id=:getId")

public class UserUpdatedExerciseAndDietEntity {


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
    @Id
    private int id;
//    @OneToMany(mappedBy = "userExerciseAndDietEntity")
//    private List<UserExerciseAndDietEntity> userExerciseAndDietEntity = new ArrayList<>();
}
