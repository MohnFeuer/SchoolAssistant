package com.classes.ejnu.dataobject;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*具体课程*/

@Entity
@Data
public class Speclass {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer speclassId;

    private String speclassName;

    //6位，aabbcc,表示三次课程的节次，00表示无
    private Integer speclassTime;

    //地点
    private String speclassLoc;

    //需要上这门课程学生学号范围，左区间
    private Integer speclassSidl;

    //右区间
    private Integer speclassSidr;

    //授课教师
    private Integer teacherId;

    //所属课程
    private Integer classesId;
}
