package com.cth.cuotiben.common;

import java.io.Serializable;

/**
 * Created by yangjiajia on 2017/5/12 0012.
 */

public class BeanInfo implements Serializable {

    private int id;
    private long createTime;
    private long updateTime;
    private String grade;
    private String subjectName;
    private Object classTime;
    private long startTime;
    private long endTime;
    private boolean regEnable;
    private long regStartTime;
    private long regEndTime;
    private int numberLimit;
    private int stock;
    private int regPrice;
    private int lastRegPrice;
    private int createUserId;
    private int introductionUserId;
    private int consultUserId;
    private String status;
    private int priority;
    private String name;
    private int cover;
    private int schoolId;
    private String address;
    private String tel;
    private String picsDspt;
    private String dspt;
    private String menuTitle;
    private String schoolName;
    private String schoolAddress;
    private boolean colleced;
    private String paidFlag;
    private int orderedNum;
    private int paidNum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Object getClassTime() {
        return classTime;
    }

    public void setClassTime(Object classTime) {
        this.classTime = classTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isRegEnable() {
        return regEnable;
    }

    public void setRegEnable(boolean regEnable) {
        this.regEnable = regEnable;
    }

    public long getRegStartTime() {
        return regStartTime;
    }

    public void setRegStartTime(long regStartTime) {
        this.regStartTime = regStartTime;
    }

    public long getRegEndTime() {
        return regEndTime;
    }

    public void setRegEndTime(long regEndTime) {
        this.regEndTime = regEndTime;
    }

    public int getNumberLimit() {
        return numberLimit;
    }

    public void setNumberLimit(int numberLimit) {
        this.numberLimit = numberLimit;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRegPrice() {
        return regPrice;
    }

    public void setRegPrice(int regPrice) {
        this.regPrice = regPrice;
    }

    public int getLastRegPrice() {
        return lastRegPrice;
    }

    public void setLastRegPrice(int lastRegPrice) {
        this.lastRegPrice = lastRegPrice;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public int getIntroductionUserId() {
        return introductionUserId;
    }

    public void setIntroductionUserId(int introductionUserId) {
        this.introductionUserId = introductionUserId;
    }

    public int getConsultUserId() {
        return consultUserId;
    }

    public void setConsultUserId(int consultUserId) {
        this.consultUserId = consultUserId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCover() {
        return cover;
    }

    public void setCover(int cover) {
        this.cover = cover;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPicsDspt() {
        return picsDspt;
    }

    public void setPicsDspt(String picsDspt) {
        this.picsDspt = picsDspt;
    }

    public String getDspt() {
        return dspt;
    }

    public void setDspt(String dspt) {
        this.dspt = dspt;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public void setMenuTitle(String menuTitle) {
        this.menuTitle = menuTitle;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public boolean isColleced() {
        return colleced;
    }

    public void setColleced(boolean colleced) {
        this.colleced = colleced;
    }

    public String getPaidFlag() {
        return paidFlag;
    }

    public void setPaidFlag(String paidFlag) {
        this.paidFlag = paidFlag;
    }

    public int getOrderedNum() {
        return orderedNum;
    }

    public void setOrderedNum(int orderedNum) {
        this.orderedNum = orderedNum;
    }

    public int getPaidNum() {
        return paidNum;
    }

    public void setPaidNum(int paidNum) {
        this.paidNum = paidNum;
    }
}
