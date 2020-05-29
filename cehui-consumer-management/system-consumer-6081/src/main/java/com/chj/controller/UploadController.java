package com.chj.controller;

import com.chj.base.BaseController;
import com.chj.base.ResultData;
import com.chj.service.CHJService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：chj
 * @date ：Created in 2020/5/29 16:39
 * @params :
 */
@RestController
@Api(value = "文件上传", tags = "文件上传的接口")
public class UploadController extends BaseController {

    @Autowired
    private CHJService chjService;

    
    /** 方法描述 
    * @Description: 文件上传
    * @Param: [file]
    * @return: com.chj.base.ResultData
    * @Author: chj
    * @Date: 2020/5/29
    */
    @PostMapping("/upload")
    @ApiOperation(value = "实现文件上传", notes = "单文件上传接口")
    public ResultData uploadFile(@RequestBody MultipartFile file) {
        if (chjService.uploadFile(file)) {
            return customSuccess("10200","上传成功");
        }
        return customFailed("20200","上传失败");
    }

}
