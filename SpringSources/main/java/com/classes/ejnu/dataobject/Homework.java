package com.classes.ejnu.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Homework {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer homeworkId;

    private String homeworkTime;

    private String homeworkInfo;

    //所属具体课程的id
    private Integer speclassId;
}
