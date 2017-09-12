/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: DecrptClassLoader
 * Author:   Administrator
 * Date:     2017/9/12 11:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sxt.gaoqi;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉<br> 
 * 〈加载文件系统中加密后的class字节码的类加载器〉
 *
 * @author Administrator
 * @create 2017/9/12
 * @since 1.0.0
 */
public class DecrptClassLoader extends ClassLoader {

    // com\sxt\gaoqi\User
    //	 -->F:\MyTest\spring-boot-in-action\JVM\src\com\sxt\gaoqi\User.class
    private String rootDir;

    public DecrptClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);

        // 应该先查询有没有加载过这个类，如果已经加载，则直接返回加载好的类。如果没有，则加载的类
        if (c != null) {
            return c;
        } else {
            ClassLoader parent = this.getParent();
            c = parent.loadClass(name);// 委派给父类加载

            if (c != null) return c;
            else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                }
                else{
                    c=defineClass(name,classData,0,classData.length);
                }
            }
        }
        return  c;
    }

    private byte[] getClassData(String classname) {
        // com\sxt\gaoqi\User
        //	 -->F:\MyTest\spring-boot-in-action\JVM\src\com\sxt\gaoqi\User.class
        String path=rootDir+"/"+classname.replace('.','/')+".class";

        //IOUtils,可以使用它将流中的数据转成字节数组

        InputStream is =null;

        ByteArrayOutputStream baos=new ByteArrayOutputStream();


        try {
            is=new FileInputStream(path);

            int temp=0;
            while((temp=is.read())!=-1){
                baos.write(temp^0xff);//取反操作
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return  null;
        }
        finally {
            try {
                if(is!=null){
                    is.close();
                }
                if(baos!=null){
                    baos.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
