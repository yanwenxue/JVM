/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: Demo3
 * Author:   Administrator
 * Date:     2017/9/11 10:11
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sxt.gaoqi;

import sun.applet.Main;

/**
 * 〈测试自定义的FileSystemClassLoader〉<br>
 * 〈〉
 *
 * @author ywx
 * @create 2017/9/11
 * @since 1.0.0
 */
public class Demo3 {
    public static void main(String args[]) throws  Exception{
        FileSystemClassLoader loader=new FileSystemClassLoader("F:/MyTest/IDEAWS/JVM/src");
        FileSystemClassLoader loader2=new FileSystemClassLoader("F:/MyTest/IDEAWS/JVM/src");

        Class<?> c=loader.loadClass("com.sxt.gaoqi.HelloWorld");
        Class<?> c2=loader.loadClass("com.sxt.gaoqi.HelloWorld");
        Class<?> c3=loader2.loadClass("com.sxt.gaoqi.HelloWorld");

        Class<?> c4=loader2.loadClass("java.lang.String");

        Class<?> c5=loader2.loadClass("com.sxt.gaoqi.Demo1");


        System.out.println(c.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());//同一个类，被不同的加载器加载，JVM认为也是不同的类
        System.out.println(c4.hashCode());

        System.out.println(c4.getClassLoader());//引导类加载器
        System.out.println(c3.getClassLoader());//自定义的类加载器
        System.out.println(c5.getClassLoader());//自定义的类加载器

    }
}