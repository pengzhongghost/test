package com.project.pojo;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    private Integer cid;

    private Integer textgrade;

    private String textvalue;

    private Integer uid;

    private Integer tid;

    private String cdate;

    private User user;

    private User senior;

    private List<Comment> replyComments=new ArrayList<>();


    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public User getSenior() {
        return senior;
    }

    public void setSenior(User senior) {
        this.senior = senior;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTextgrade() {
        return textgrade;
    }

    public void setTextgrade(Integer textgrade) {
        this.textgrade = textgrade;
    }

    public String getTextvalue() {
        return textvalue;
    }

    public void setTextvalue(String textvalue) {
        this.textvalue = textvalue == null ? null : textvalue.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }


}