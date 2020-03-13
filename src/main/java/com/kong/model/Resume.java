package com.kong.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Resume implements Serializable {
    private int id;
    private String name;
    private String gender;
    private Date birthDate;
    private Date workDate;
    private String birthProvince;
    private String birthCity;
    private String liveProvince;
    private String liveCity;
    private String liveCounty;
    private String phone;
    private String mail;
    private String identity;
    private String workCharacter;
    private String expectPlace;
    private String expectJob;
    private String expectPost;
    private String expectSalary;
    private Date modifyTime;
    private Date createTime;
    private int userId;
    private List<Project> projects;
    private List<Education> educations;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getBirthProvince() {
        return birthProvince;
    }

    public void setBirthProvince(String birthProvince) {
        this.birthProvince = birthProvince;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getLiveProvince() {
        return liveProvince;
    }

    public void setLiveProvince(String liveProvince) {
        this.liveProvince = liveProvince;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }

    public String getLiveCounty() {
        return liveCounty;
    }

    public void setLiveCounty(String liveCounty) {
        this.liveCounty = liveCounty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getWorkCharacter() {
        return workCharacter;
    }

    public void setWorkCharacter(String workCharacter) {
        this.workCharacter = workCharacter;
    }

    public String getExpectPlace() {
        return expectPlace;
    }

    public void setExpectPlace(String expectPlace) {
        this.expectPlace = expectPlace;
    }

    public String getExpectJob() {
        return expectJob;
    }

    public void setExpectJob(String expectJob) {
        this.expectJob = expectJob;
    }

    public String getExpectPost() {
        return expectPost;
    }

    public void setExpectPost(String expectPost) {
        this.expectPost = expectPost;
    }

    public String getExpectSalary() {
        return expectSalary;
    }

    public void setExpectSalary(String expectSalary) {
        this.expectSalary = expectSalary;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", workDate=" + workDate +
                ", birthProvince='" + birthProvince + '\'' +
                ", birthCity='" + birthCity + '\'' +
                ", liveProvince='" + liveProvince + '\'' +
                ", liveCity='" + liveCity + '\'' +
                ", liveCounty='" + liveCounty + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", identity='" + identity + '\'' +
                ", workCharacter='" + workCharacter + '\'' +
                ", expectPlace='" + expectPlace + '\'' +
                ", expectJob='" + expectJob + '\'' +
                ", expectPost='" + expectPost + '\'' +
                ", expectSalary='" + expectSalary + '\'' +
                ", modifyTime=" + modifyTime +
                ", createTime=" + createTime +
                ", userId=" + userId +
                ", projects=" + projects +
                ", educations=" + educations +
                '}';
    }
}
