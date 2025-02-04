package com.xworkz.Sohita_Gym.Entity;

import com.xworkz.Sohita_Gym.AbstractAuditEntity.ViewAbstractAuditEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
@Table(name = "followup_view_table")
@NamedQuery(name = "getAllData", query = "SELECT e FROM  ViewEnqDetailsEntity e WHERE e.enquiryEntity.enquiryId = :setEnquiryId")

public class ViewEnqDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "view_id")
    private int viewId;
    private String area;
    private String name;
    private long phoneNo;
    private String Reasons;
    @ManyToOne
    @JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
    //@JoinColumn(name = "enquiryId", insertable = false, updatable = false)
    private EnquiryEntity enquiryEntity;
}
    ///////////////
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "view_id")
//    private int viewId;
//
//    @Column(name = "Package")
//    private String PackageType;
//
//    @Column(name = "Trainer")
//    private String trainerName;
//
//    @Column(name = "Amount")
//    private double amount;
//
//    @Column(name = "AmountPaid")
//    private double amountPaid;
//
//    @Column(name = "Balance")
//    private double balance;
//
//    @Column(name = "RegistrationUpdateDate")
//    private LocalDate regUpdateDate;
//
//    private RegistrationEntity registrationEntity;
//}