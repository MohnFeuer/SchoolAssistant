package com.classes.ejnu.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Student {

    @Id
    private Integer studentId;

    private String studentName;

    private String studentPassword;

    //头像链接
    private String studentIcon;

    //学生所属专业id
    private Integer majorId;
}
