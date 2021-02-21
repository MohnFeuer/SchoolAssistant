package com.classes.ejnu.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer bookId;

    //书名
    private String bookName;

    //信息
    private String bookInfo;

    //图标
    private String bookIcon;
}
