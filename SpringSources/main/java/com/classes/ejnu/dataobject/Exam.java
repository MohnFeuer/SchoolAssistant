package com.classes.ejnu.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Exam {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer examId;

    //考试名
    private String examName;

    //详细信息
    private String examInfo;

    //考试时间
    private String examTime;


}
