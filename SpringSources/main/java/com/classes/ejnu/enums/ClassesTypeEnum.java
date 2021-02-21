package com.classes.ejnu.enums;


import lombok.Getter;

//课程类型
@Getter
public enum ClassesTypeEnum {

    REQ(0, "必修"),
    ELE(1, "选修")
    ;

    private Integer code;

    private String message;

    ClassesTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
