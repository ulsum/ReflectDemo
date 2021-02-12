package com.ulsum.reflect.demo6;

import com.ulsum.reflect.demo6.entity.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetDeclaredSample {

    public static void main(String[] args) {
        try {
            Class employeeClass = Class.forName("com.ulsum.reflect.demo6.entity.Employee");
            Constructor employeeConstructor = employeeClass.getConstructor(new Class[]{
                    Integer.class, String.class, Float.class, String.class
            });
            Employee employee = (Employee) employeeConstructor.newInstance(new Object[]{
                    100, "李雷", 3000f, "研发部"
            });
            // 获取当前类所有成员变量
            Field[] fields = employeeClass.getDeclaredFields();
            for (Field f : fields) {
                if (f.getModifiers() == 1) {     // public修饰的
                    Object val = f.get(employee);
                    System.out.println(f.getName() + " : " + val);
                } else if (f.getModifiers() == 2) {    // private修饰的
                    String methodName = "get" + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1);
                    Method getMethod = employeeClass.getMethod(methodName);
                    Object ret = getMethod.invoke(employee);
                    System.out.println(f.getName() + " : " + ret);
                }
            }
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
