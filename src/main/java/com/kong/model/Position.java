package com.kong.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Position implements Serializable {
    private int p_id;
    private String p_name;
    private String xueli;
    private String salary;
    private String workProvince;
    private String workCity;
    private String detailAdr;
    private String functionType;
    private int num;
    private String brief;
    private String employeeType;
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date publicTime;
    private int publicId;
    private int state;

    private List<Resume> resumes;

    public List<Resume> getResumes() {
        return resumes;
    }

    public void setResumes(List<Resume> resumes) {
        this.resumes = resumes;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getXueli() {
        return xueli;
    }

    public void setXueli(String xueli) {
        this.xueli = xueli;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getWorkProvince() {
        return workProvince;
    }

    public void setWorkProvince(String workProvince) {
        this.workProvince = workProvince;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getDetailAdr() {
        return detailAdr;
    }

    public void setDetailAdr(String detailAdr) {
        this.detailAdr = detailAdr;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public int getPublicId() {
        return publicId;
    }

    public void setPublicId(int publicId) {
        this.publicId = publicId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Position{" +
                "p_id=" + p_id +
                ", p_name='" + p_name + '\'' +
                ", xueli='" + xueli + '\'' +
                ", salary='" + salary + '\'' +
                ", workProvince='" + workProvince + '\'' +
                ", workCity='" + workCity + '\'' +
                ", detailAdr='" + detailAdr + '\'' +
                ", functionType='" + functionType + '\'' +
                ", num=" + num +
                ", brief='" + brief + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", publicTime=" + publicTime +
                ", publicId=" + publicId +
                ", state=" + state +
                ", resumes=" + resumes +
                '}';
    }
}
