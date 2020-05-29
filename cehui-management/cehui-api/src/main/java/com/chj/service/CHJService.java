package com.chj.service;

import com.chj.base.ResultData;
import com.chj.model.login.User;
import com.chj.vo.TokenVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 18:28
 * @params :
 */
@FeignClient(value = "system-interface")
public interface CHJService {
    /**-------------------------------- 登录管理----->日志管理-----------------------------------------------*/

    /** 方法描述
    * @Description: 文件上传
     *              feign默认只支持发送普通类型（八大基本数据类型  封装类型  集合...）
     *              修改PostMapper配置  去接收Multipart/form-data类型  让feign使用json的数据格式来进行接收
    * @Param: [file]
    * @return: java.lang.Boolean
    * @Author: chj
    * @Date: 2020/5/29
    */
    @PostMapping(value = "/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    Boolean uploadFile(@RequestBody MultipartFile file);


    /** 方法描述
     * @Description: 执行登录操作
     * @Param: [user]
     * @return: com.chj.vo.TokenVo
     * @Author: chj
     * @Date: 2020/5/15
     */
    @PostMapping("/doLogin")
    TokenVo doLogin(@RequestBody User user);

    /** 方法描述
     * @Description: 添加登录日志信息
     * @Param: [map]
     * @return: com.eight.base.ResultData
     * @Author: chj
     * @Date: 2020/5/27
     */
    @PostMapping("loginAddByMap")
    ResultData loginAddByMap(@RequestBody Map map);
}





