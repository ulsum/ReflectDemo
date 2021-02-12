package com.ulsum.reflect.demo5;

import com.ulsum.reflect.demo5.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldSample {

    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.ulsum.reflect.demo5.entity.Employee");
            Constructor employeeConstructor = employeeClass.getConstructor(new Class[]{
                    Integer.class, String.class, Float.class, String.class
            });
            Employee employee = (Employee) employeeConstructor.newInstance(new Object[]{
                    100, "李磊", 3000f, "研发部"
            });
            Field enameField = employeeClass.getField("ename");
            String ename = (String) enameField.get(employee);
            System.out.println("原先的ename = " + employee.ename);
            enameField.set(employee,"李雷");
            System.out.println("更新的ename = " + employee.ename);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {      // 没有找到对应成员变量时，抛出的异常
            e.printStackTrace();
        }
    }

}
