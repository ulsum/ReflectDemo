package com.ulsum.reflect.demo2;

import com.ulsum.reflect.demo2.entity.Employee;

public class ClassSample {

    public static void main(String[] args) {
        try {
            // Class.forName()方法将制定的类加载到JVM中，并返回对应Class对象
            Class employeeClass = Class.forName("com.ulsum.reflect.demo2.entity.Employee");
            System.out.println("Employee已被加载到JVM中");
            Employee employee = (Employee) employeeClass.newInstance();
            System.out.println(employee);
        } catch (ClassNotFoundException e) {    // 类不存在异常forName()的参数错误
            e.printStackTrace();
        } catch (IllegalAccessException e) {    // 类非法访问异常，newInstance()的默认构造方法是私有的
            e.printStackTrace();
        } catch (InstantiationException e) {    // 类对象实例化异常，Employee类是abstract的，abstract类不能被实例化
            e.printStackTrace();
        }
    }

}
