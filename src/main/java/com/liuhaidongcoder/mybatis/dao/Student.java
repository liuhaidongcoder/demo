package com.liuhaidongcoder.mybatis.dao;

import com.liuhaidongcoder.mybatis.enums.ProfessionalEnum;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author Liu Haidong
 * @date 20/12/7
 */

public class Student {
    private long id;
    private String name;
    private int age;
    private String sex;
    private ProfessionalEnum professional;
    private Timestamp gmtModified;

    public Professional getPro() {
        return pro;
    }

    public void setPro(Professional pro) {
        this.pro = pro;
    }

    private Professional pro;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    private String test;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Timestamp gmtModified) {
        this.gmtModified = gmtModified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfessionalEnum getProfessional() {
        return professional;
    }

    public void setProfessional(ProfessionalEnum professional) {
        this.professional = professional;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
