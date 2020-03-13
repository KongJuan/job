package com.kong.model;

import java.io.Serializable;
import java.util.Date;

public class Education implements Serializable {
    private int eduId;
    private String schoolName;
    private Date startDate;
    private Date endDate;
    private String major;
    private int isUnified;
    private String degree;
    private int resumeId;

    public int getEduId() {
        return eduId;
    }

    public void setEduId(int eduId) {
        this.eduId = eduId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getIsUnified() {
        return isUnified;
    }

    public void setIsUnified(int isUnified) {
        this.isUnified = isUnified;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public String toString() {
        return "Education{" +
                "eduId=" + eduId +
                ", schoolName='" + schoolName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", major='" + major + '\'' +
                ", isUnified=" + isUnified +
                ", degree='" + degree + '\'' +
                ", resumeId=" + resumeId +
                '}';
    }
}
