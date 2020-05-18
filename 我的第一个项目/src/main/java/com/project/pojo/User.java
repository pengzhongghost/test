package com.project.pojo;


import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class User {
    private Integer uid;

    private String username;
    @NotBlank
    @Length(min = 5,max = 9)
    private String password;

    private String realname;

    private String phone;

    private int did;

    private int right1;  //权限，1代表内部员工，2代表用户

    private int pid;  //职务，null代表非员工

    private Position position;

    private String hiredate;

    private Department department;

    private String onduty; //是否在职

    private String leavedate;

    private String identity; //身份证

    private String sex;

    private List<Duty> duties;

    private String file;

    public User(Integer uid, String username, @NotBlank @Length(min = 5, max = 9) String password, String realname, String phone, int did, int right1, int pid, Position position, String hiredate, Department department, String onduty, String leavedate, String identity, String sex, List<Duty> duties, String file) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.phone = phone;
        this.did = did;
        this.right1 = right1;
        this.pid = pid;
        this.position = position;
        this.hiredate = hiredate;
        this.department = department;
        this.onduty = onduty;
        this.leavedate = leavedate;
        this.identity = identity;
        this.sex = sex;
        this.duties = duties;
        this.file = file;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public List<Duty> getDuties() {
        return duties;
    }

    public void setDuties(List<Duty> duties) {
        this.duties = duties;
    }

    public int getRight1() {
        return right1;
    }

    public void setRight1(int right1) {
        this.right1 = right1;
    }



    public String getOnduty() {
        return onduty;
    }

    public void setOnduty(String onduty) {
        this.onduty = onduty;
    }

    public String getLeavedate() {
        return leavedate;
    }

    public void setLeavedate(String leavedate) {
        this.leavedate = leavedate;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }


//    public int getRight() {
//        return right1;
//    }
//
//    public void setRight(int right) {
//        this.right1 = right;
//    }


    public User(String username, @NotBlank @Length(min = 5, max = 9) String password, int right1) {
        this.username = username;
        this.password = password;
        this.right1 = right1;
    }

    public User(Integer uid, String username, @NotBlank @Length(min = 5, max = 9) String password, String realname, int right1) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.right1 = right1;
    }

    public User() {
    }

    public User(Integer uid, String username, @NotBlank @Length(min = 5, max = 9) String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User(Integer uid, String username, @NotBlank @Length(min = 5, max = 9) String password, String realname) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getId() {
        return uid;
    }

    public void setId(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", did=" + did +
                ", right1=" + right1 +
                ", pid=" + pid +
                ", position=" + position +
                ", hiredate='" + hiredate + '\'' +
                ", department=" + department +
                ", onduty='" + onduty + '\'' +
                ", leavedate='" + leavedate + '\'' +
                ", identity='" + identity + '\'' +
                ", sex='" + sex + '\'' +
                ", duties=" + duties +
                ", file=" + file +
                '}';
    }
}