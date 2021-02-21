package com.classes.ejnu.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Contest {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer contestId;

    private String contestName;

    private String contestInfo;

    private String contestTime;
}
