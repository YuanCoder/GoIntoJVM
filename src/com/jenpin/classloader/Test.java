package com.jenpin.classloader;

/**
 * @author: Jenpin
 * @date: 2018/8/8 0008 10:41
 * @email: yuan_268311@163.com
 * @description:
 **/
public class Test {
    static {
        System.out.println("静态初始化块执行了！");
    }
    public void hello() {
        System.out.println("恩，是的，我是由 " + getClass().getClassLoader().getClass() + " 加载进来的");
    }
}
