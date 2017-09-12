/**
 * Copyright (C), 2015-2017, XXX有限公司
 * FileName: EncrptUtil
 * Author:   Administrator
 * Date:     2017/9/11 17:19
 * Description: 加密工具类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sxt.gaoqi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 〈一句话功能简述〉<br> 
 * 〈加密工具类〉
 *
 * @author Administrator
 * @create 2017/9/11
 * @since 1.0.0
 */
public class EncrptUtil {
    public static void main(String[] args){
        encrpt(new File("F:/myjava/HelloWorld.class"),new File("F:/myjava/temp/HelloWorld.class"));
    }

    public static void encrpt(File src, File dest){
        FileInputStream fis=null;
        FileOutputStream fos=null;

        try {
            fis=new FileInputStream(src);
            fos=new FileOutputStream(dest);

            int temp=1;
            while ((temp=fis.read())!=-1){
                fos.write(temp^0xff);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fis!=null)
                    fis.close();
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}