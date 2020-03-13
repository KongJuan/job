package com.kong.model;

import java.io.Serializable;
import java.util.List;

public class Recruiter extends Search implements Serializable {
    private int cid;
    private String cname;
    private String cpwd;
    private String realname;
    private String pos;
    private String email;
    private String phone;
    private String companyName;
    private String address;
    private String companyType;
    private String cbrief;
    private String trade;
    private String subsidy;
    private int status;
    private List<Position> positions;

    public List<Position> getPositions() {
        return positions;
    }

    public void setPositions(List<Position> positions) {
        this.positions = positions;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCbrief() {
        return cbrief;
    }

    public void setCbrief(String cbrief) {
        this.cbrief = cbrief;
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

    public int getStates() {
        return status;
    }

    public void setStates(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Recruiter{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cpwd='" + cpwd + '\'' +
                ", realname='" + realname + '\'' +
                ", pos='" + pos + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", companyType='" + companyType + '\'' +
                ", cbrief='" + cbrief + '\'' +
                ", trade='" + trade + '\'' +
                ", subsidy='" + subsidy + '\'' +
                ", states=" + status +
                ", positions=" + positions +
                '}';
    }
}
