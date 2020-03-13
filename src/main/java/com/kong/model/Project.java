package com.kong.model;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private int proId;
    private String projectName;
    private Date startTime;
    private Date endTime;
    private String projectDesc;
    private String personalWork;
    private String companyName;
    private int resumeId;

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getPersonalWork() {
        return personalWork;
    }

    public void setPersonalWork(String personalWork) {
        this.personalWork = personalWork;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    @Override
    public String toString() {
        return "Project{" +
                "proId=" + proId +
                ", projectName='" + projectName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", projectDesc='" + projectDesc + '\'' +
                ", personalWork='" + personalWork + '\'' +
                ", companyName='" + companyName + '\'' +
                ", resumeId=" + resumeId +
                '}';
    }
}
