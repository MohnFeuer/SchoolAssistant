package com.classes.ejnu.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Classes {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer classesId;

    private String classesName;

    //课程类型，必修0，选修1
    private Integer classesType;

    //课程所属专业id
    private Integer majorId;
}
