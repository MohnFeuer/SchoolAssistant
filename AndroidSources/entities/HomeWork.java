package com.example.imoocmusicdemo.entities;

public class HomeWork {
    private Integer homeworkId;

    private String homeworkTime;

    private String homeworkInfo;

    //所属具体课程的id
    private Integer speclassId;

    public Integer getHomeworkId() {
        return homeworkId;
    }

    public void setHomeworkId(Integer homeworkId) {
        this.homeworkId = homeworkId;
    }

    public String getHomeworkTime() {
        return homeworkTime;
    }

    public void setHomeworkTime(String homeworkTime) {
        this.homeworkTime = homeworkTime;
    }

    public String getHomeworkInfo() {
        return homeworkInfo;
    }

    public void setHomeworkInfo(String homeworkInfo) {
        this.homeworkInfo = homeworkInfo;
    }

    public Integer getSpeclassId() {
        return speclassId;
    }

    public void setSpeclassId(Integer speclassId) {
        this.speclassId = speclassId;
    }
}
