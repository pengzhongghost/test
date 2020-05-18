package com.project.pojo;

import java.util.ArrayList;
import java.util.List;

public class Blog {
    private Integer tid;

    private String title;

    private String text;

    private String date;

    private Integer uid;

    private Integer publish;   //0代表保存未发布，1代表发布

    private User user;

    private String introduction;

    private Integer point;

    private Integer star;

    private Integer starperson;

    private Comment comment3;

    private List<Comment> comments=new ArrayList<>();

    private List<Comment> comments2=new ArrayList<>();   //二级评论

    private List<Comment> comments3=new ArrayList<>();   //二级评论的评论

    public Comment getComment3() {
        return comment3;
    }


    public void setComment3(Comment comment3) {
        this.comment3 = comment3;
    }

    public List<Comment> getComments3() {
        return comments3;
    }

    public void setComments3(List<Comment> comments3) {
        this.comments3 = comments3;
    }

    public List<Comment> getComments2() {
        return comments2;
    }

    public void setComments2(List<Comment> comments2) {
        this.comments2 = comments2;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Integer getStarperson() {
        return starperson;
    }

    public void setStarperson(Integer starperson) {
        this.starperson = starperson;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPublish() {
        return publish;
    }

    public void setPublish(Integer publish) {
        this.publish = publish;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", uid=" + uid +
                ", publish=" + publish +
                ", user=" + user +
                ", introduction='" + introduction + '\'' +
                ", point=" + point +
                ", star=" + star +
                ", starperson=" + starperson +
                ", comments=" + comments +
                ", comments2=" + comments2 +
                ", comments3=" + comments3 +
                '}';
    }
}