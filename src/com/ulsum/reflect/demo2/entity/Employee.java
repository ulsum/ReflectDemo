package com.ulsum.reflect.demo2.entity;

public class Employee {

    // 一个类在被加载时，要经过初始化，类的初始化是通过静态块完成的
    static {
        System.out.println("Employee类已被加载到JVM中，并已初始化");
    }

    private Integer eno;
    private String ename;
    private Float salary;
    private String dname;

    public Employee() {
        System.out.println("Employee默认构造方法被执行");
    }

    public Integer getEno() {
        return eno;
    }

    public void setEno(Integer eno) {
        this.eno = eno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

}
