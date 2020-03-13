package com.kong.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class RecruiterPosition {
    private String companyName;
    private String workCity;
    private String trade;
    private String subsidy;
    private String pName;
    private String degree;
    private String salary;
    private String employeeType;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date publicTime;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getSubsidy() {
        return subsidy;
    }

    public void setSubsidy(String subsidy) {
        this.subsidy = subsidy;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
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

    @Override
    public String toString() {
        return "RecruiterPosition{" +
                "companyName='" + companyName + '\'' +
                ", address='" + workCity + '\'' +
                ", trade='" + trade + '\'' +
                ", subsidy='" + subsidy + '\'' +
                ", p_name='" + pName + '\'' +
                ", xueli='" + degree + '\'' +
                ", salary='" + salary + '\'' +
                ", employeeType='" + employeeType + '\'' +
                ", publicTime=" + publicTime +
                '}';
    }
}
