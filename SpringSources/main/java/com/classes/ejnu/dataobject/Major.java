package com.classes.ejnu.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Major {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer majorId;

    private String majorName;

}
