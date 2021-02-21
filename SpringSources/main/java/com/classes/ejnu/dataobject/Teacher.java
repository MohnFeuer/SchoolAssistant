package com.classes.ejnu.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Teacher {

    @Id
    private Integer teacherId;

    private String teacherName;

    //头像链接
    private String teacherIcon;

    //密码
    private String teacherPassword;

    //所属专业
    private Integer majorId;
}
