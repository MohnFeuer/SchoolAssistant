package com.classes.ejnu.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Office {

    //管理员id
    @Id
    private String officeId;

    //管理员密码
    private String officePassword;


}
