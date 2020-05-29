package com.chj.service;

import com.chj.properties.FTPProperties;
import com.chj.utils.DateUtils;
import com.chj.utils.FTPUtils;
import com.chj.utils.FileNameUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @author ：chj
 * @date ：Created in 2020/5/29 16:15
 * @params :
 */
@Service
public class UploadService {

    @Autowired
    private FTPProperties ftpProperties;

    /** 方法描述
    * @Description: ftp文件上传
    * @Param: [file]
    * @return: java.lang.Boolean
    * @Author: chj
    * @Date: 2020/5/29
    */
    public Boolean upload(MultipartFile file){
        //获取原始文件的名称
        String oldFileName = file.getOriginalFilename();
        //获取新的文件名
        String newFileName = FileNameUtils.getFileName();
        //原始文件名的后缀补到新文件名上
        newFileName += oldFileName.substring(oldFileName.lastIndexOf("."));


        //获取日期格式化后的数据
        String filePath = DateUtils.formatDate(new Date(), "yyyy/MM/dd");
        //ftp上传工具类
        try {
          return   FTPUtils.uploadFile(ftpProperties.getHost(),ftpProperties.getPort(),ftpProperties.getUsername(),
                   ftpProperties.getPassword(),filePath,ftpProperties.getBasePath(),newFileName,file.getInputStream() );
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}















