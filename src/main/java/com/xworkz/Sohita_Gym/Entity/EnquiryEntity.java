package com.xworkz.Sohita_Gym.Entity;

import com.xworkz.Sohita_Gym.AbstractAuditEntity.AdminAbstractAuditEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Table(name="enquiry_table")

@NamedQuery(name="getAllDetailsOfEnquiry",query = "select e from EnquiryEntity e")
@NamedQuery(name="getPhoneNoByName", query = "select p.phoneNo from EnquiryEntity p where p.name = :setName")
@NamedQuery(name="getPhoneNo",query  ="select p.phoneNo from EnquiryEntity p where p.name = :byName")

public class EnquiryEntity extends AdminAbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enquiryId;
    @Column(name= "name")
    private String name;
    @Column(name= "age")
    private int age;
    @Column(name= "area")
    private String area;
    @Column(name= "phoneNo")
    private long phoneNo;
    @Column(name= "distance")
    private int distance;
    @Column(name= "reasons")
    private String reasons;
    @Column(name= "status")
    private String status;

    @OneToMany(mappedBy = "enquiryEntity")
    private List<ViewEnqDetailsEntity> viewEnqDetailsEntity = new ArrayList<>();
}
