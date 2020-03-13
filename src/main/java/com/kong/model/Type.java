package com.kong.model;

import java.io.Serializable;

public class Type implements Serializable {
    private String code;
    private String tname;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Type{" +
                "code='" + code + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }
}
