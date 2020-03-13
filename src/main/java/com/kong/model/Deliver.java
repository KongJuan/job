package com.kong.model;

import java.io.Serializable;
import java.util.Date;

public class Deliver implements Serializable {
    private int id;
    private int pid;
    private int rid;
    private int state;
    private Date deliverTime;
    private Date lookTime;
    private  Date wantTime;
    private Date inviteTime;
    private Date unsuitedTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getLookTime() {
        return lookTime;
    }

    public void setLookTime(Date lookTime) {
        this.lookTime = lookTime;
    }

    public Date getWantTime() {
        return wantTime;
    }

    public void setWantTime(Date wantTime) {
        this.wantTime = wantTime;
    }

    public Date getInviteTime() {
        return inviteTime;
    }

    public void setInviteTime(Date inviteTime) {
        this.inviteTime = inviteTime;
    }

    public Date getUnsuitedTime() {
        return unsuitedTime;
    }

    public void setUnsuitedTime(Date unsuitedTime) {
        this.unsuitedTime = unsuitedTime;
    }

    @Override
    public String toString() {
        return "Deliver{" +
                "id=" + id +
                ", pid=" + pid +
                ", rid=" + rid +
                ", state=" + state +
                ", deliverTime=" + deliverTime +
                ", lookTime=" + lookTime +
                ", wantTime=" + wantTime +
                ", inviteTime=" + inviteTime +
                ", unsuitedTime=" + unsuitedTime +
                '}';
    }
}
