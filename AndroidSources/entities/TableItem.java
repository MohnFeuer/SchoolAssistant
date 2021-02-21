package com.example.imoocmusicdemo.entities;

public class TableItem {

    private boolean isShow;

    private Integer speclassId;

    public Integer getSpeclassId() {
        return speclassId;
    }

    public void setSpeclassId(Integer speclassId) {
        this.speclassId = speclassId;
    }

    private String itemName;

    private String itemLoc;

    private Integer teacherId;

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemLoc() {
        return itemLoc;
    }

    public void setItemLoc(String itemLoc) {
        this.itemLoc = itemLoc;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }
}
