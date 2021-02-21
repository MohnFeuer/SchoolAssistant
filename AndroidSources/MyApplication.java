package com.example.imoocmusicdemo;

import android.app.Application;

import com.blankj.utilcode.util.Utils;
import com.example.imoocmusicdemo.entities.Student;

//全局的对象，可以存储一些系统的信息。
//应用打开后，application立刻运行
public class MyApplication extends Application {

    public Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);
    }
}
