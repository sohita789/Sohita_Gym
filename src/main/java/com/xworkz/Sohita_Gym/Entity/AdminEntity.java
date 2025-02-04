package com.xworkz.Sohita_Gym.Entity;

import com.xworkz.Sohita_Gym.AbstractAuditEntity.AdminAbstractAuditEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@RequiredArgsConstructor
@Table(name="admin_table")
@NamedQuery(name="getNameByEmailAndPassword",query="select g.id from AdminEntity g where g.email = :setEmail AND g.password = :setPassword")
@NamedQuery(name = "getCountOfAdminUserNameByEmail", query = "select count(*) from AdminEntity a where a.email=:setEmail")
@NamedQuery(name = "getCountOfAdminUserNameByPassword", query = "select count(*) from AdminEntity a where a.email=:setPassword")

public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String password;


}
//     @Column(name = "login_count")
//     private  int login_count;
//     @Column(name = "profile_image")
//     private  String image;




