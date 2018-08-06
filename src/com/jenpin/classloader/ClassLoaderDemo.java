package com.jenpin.classloader;/**
 * Created by Administrator on 2018/8/6.
 */

/**
 * @author: Jenpin
 * @date: 2018/8/6 23:13
 * @email: yuan_268311@163.com
 * @description: 寻找类加载器
 **/
public class ClassLoaderDemo {

    public static void main(String[] args){
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }

    /**
     * 运行结果并没有获取到ExtClassLoader的父Loader，原因是Bootstrap Loader（引导类加载器）是用C语言实现的，
     * 找不到一个确定的返回父Loader的方式，于是就返回null。
     */
}
