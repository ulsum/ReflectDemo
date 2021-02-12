package com.ulsum.reflect.demo4;

import com.ulsum.reflect.demo4.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodSample {

    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.ulsum.reflect.demo4.entity.Employee");
            Constructor employeeConstructor = employeeClass.getConstructor(new Class[]{
                    Integer.class, String.class, Float.class, String.class
            });
            Employee employee = (Employee) employeeConstructor.newInstance(new Object[]{
                    100, "李磊", 3000f, "研发部"
            });
            Method updateSalaryMethod = employeeClass.getMethod("updateSalary", new Class[]{
                    Float.class
            });   // 方法名称 + 参数类型列表
            Employee employeeNew = (Employee) updateSalaryMethod.invoke(employee, new Object[]{
                    1000f
            });     // 执行的对象 + 参数列表
            System.out.println(employeeNew);
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
        }
    }

}
