package org.lanqiao.mybatis3.entity;

import java.util.Date;

/**
 * ORM entity类，当前类对应一个数据库表，每个成员变量对应一个数据库表的字段。<br/>
 * 每一个实例化的对象就是一行数据。
 * @author 任宏友
 *
 */
public class Student {
    private Integer studId;
    private String name;
    private String email;
    private Date dob;

    public Student() {
        // TODO Auto-generated constructor stub
    }

    public Student(Integer studId, String name, String email, Date dob) {
        super();
        this.studId = studId;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }
    
    public Integer getStudId() {
        return studId;
    }
    
    public void setStudId(Integer studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    @Override
    public String toString() {
        return "Student [studId=" + studId + ", name=" + name + ", email=" + email + ", dob=" + dob
                + "]";
    }
    
}
