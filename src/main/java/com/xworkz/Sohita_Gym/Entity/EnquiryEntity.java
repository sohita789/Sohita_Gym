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

public class EnquiryEntity extends AdminAbstractAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int enquiryId;
    private String name;
    private int age;
    private String area;
    private long phoneNo;
    private int distance;
    private String reasons;
    private String status;
    @OneToMany(mappedBy = "enquiryEntity")
    private List<ViewEnqDetailsEntity> viewEnqDetailsEntity = new ArrayList<>();
}
