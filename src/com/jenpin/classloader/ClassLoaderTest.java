package com.jenpin.classloader;/**
 * Created by Administrator on 2018/8/6.
 */

/**
 * @author: Jenpin
 * @date: 2018/8/6 23:56
 * @email: yuan_268311@163.com
 * @description: 类的加载
 **/
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoaderTest.class.getClassLoader();
        System.out.println(loader);
        //使用ClassLoader.loadClass()来加载类，不会执行初始化块
         loader.loadClass("com.jenpin.classloader.Test");
        //使用Class.forName()来加载类，默认会执行初始化块
//         Class.forName("com.jenpin.classloader.Test2");
        //使用Class.forName()来加载类，并指定ClassLoader，初始化时不执行静态块
//        Class.forName("com.jenpin.classloader.Test2", true, loader);
    }
}

class Test3{
    static {
        System.out.println("Test3.class 静态初始化块执行了！");
    }
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass() + " 加载进来的");
    }
}