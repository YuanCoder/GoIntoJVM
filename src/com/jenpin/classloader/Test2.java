package com.jenpin.classloader;

/**
 * @author: Jenpin
 * @date: 2018/8/8 0008 16:57
 * @email: yuan_268311@163.com
 * @description:
 **/
public class Test2 {
    static {
        System.out.println("Test2.class 静态初始化块执行了！");
    }

    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass() + " 加载进来的");
    }
}
