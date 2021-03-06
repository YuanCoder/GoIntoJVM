package com.jenpin.classloader;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author: Jenpin
 * @date: 2018/8/7 0:33
 * @email: yuan_268311@163.com
 * @description: 定义类加载器来实现 将经过了加密处理网络来传输 Java类的字节码
 **/
public class MyClassLoader extends ClassLoader{
    private String root;

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    /**
     * 将class 文件转换为字节数组
     * @param className
     * @return
     */
    private byte[] loadClassData(String className) {
        String fileName = root + File.separatorChar
                + className.replace('.', File.separatorChar) + ".class";
        try {
            InputStream ins = new FileInputStream(fileName);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 1024;
            byte[] buffer = new byte[bufferSize];
            int length = 0;
            while ((length = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, length);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    public static void main(String[] args)  {

        MyClassLoader classLoader = new MyClassLoader();
        classLoader.setRoot("D:\\");
        Class<?> clazz = null;
        try {
            clazz = classLoader.loadClass("com.jenpin.classloader.Test");
            System.out.println(clazz.getClass().getModifiers());
            System.out.println(Modifier.toString(clazz.getClass().getModifiers()));
            System.out.println(Modifier.isPublic(17));
//            Modifier.classModifiers();

            Object object = clazz.newInstance();
            System.out.println(object.getClass().getClassLoader());
            Method helloMethod = clazz.getDeclaredMethod("hello", null);
            helloMethod.invoke(object, null);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
