package com.xworkz.Sohita_Gym.AbstractAuditEntity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass

public class AdminAbstractAuditEntity implements Serializable {

    private String  createdBy;
    private LocalDateTime createdDate  = LocalDateTime.now();
    private String updatedBy;
    private LocalDateTime updatedDate =  LocalDateTime.now();
}
