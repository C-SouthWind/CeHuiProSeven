package com.chj.utils;


import java.util.Random;

/**
 * @author ：chj
 * @date ：Created in 2020/5/29 16:18
 * @params :
 */
public class FileNameUtils {

    private FileNameUtils(){

    }

    /** 方法描述
    * @Description: 生成新的文件名
    * @Param: []
    * @return: java.lang.String
    * @Author: chj
    * @Date: 2020/5/29
    */
    public static String getFileName(){
        //获取时间的毫秒数
        long timeMillis = System.currentTimeMillis();
        //创建Random对象
        Random random = new Random();
        //做一个随机数
        Integer randomNum = random.nextInt(999);
        //生成文件名
        String fileName = timeMillis + String.format("%03d",randomNum);
        return fileName;
    }
}
