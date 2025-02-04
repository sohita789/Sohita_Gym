package com.xworkz.Sohita_Gym.AbstractAuditEntity;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data
public class ViewAbstractAuditEntity implements Serializable {

    private LocalDateTime updatedOn;

}
