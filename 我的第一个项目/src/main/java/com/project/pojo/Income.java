package com.project.pojo;

import java.util.Date;

public class Income {

    private int iid;

    private Double amount;

    private String type;

    private String idate;

    private String idesc;

    public Income() {
    }

    public Income(int iid, Double amount, String type, String idate, String idesc) {
        this.iid = iid;
        this.amount = amount;
        this.type = type;
        this.idate = idate;
        this.idesc = idesc;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getIdate() {
        return idate;
    }

    public void setIdate(String idate) {
        this.idate = idate;
    }

    public String getIdesc() {
        return idesc;
    }

    public void setIdesc(String idesc) {
        this.idesc = idesc;
    }

    @Override
    public String toString() {
        return "Income{" +
                "iid=" + iid +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", idate='" + idate + '\'' +
                ", idesc='" + idesc + '\'' +
                '}';
    }
}