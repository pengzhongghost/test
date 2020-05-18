package com.project.pojo;

public class Position {
    private Integer posid;

    private String posiname;

    private String posidesc;

    public Integer getPosid() {
        return posid;
    }

    public void setPosid(Integer posid) {
        this.posid = posid;
    }

    public String getPosiname() {
        return posiname;
    }

    public void setPosiname(String posiname) {
        this.posiname = posiname == null ? null : posiname.trim();
    }

    public String getPosidesc() {
        return posidesc;
    }

    public void setPosidesc(String posidesc) {
        this.posidesc = posidesc == null ? null : posidesc.trim();
    }

    @Override
    public String toString() {
        return "Position{" +
                "posid=" + posid +
                ", posiname='" + posiname + '\'' +
                ", posidesc='" + posidesc + '\'' +
                '}';
    }
}