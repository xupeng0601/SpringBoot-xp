package org.xp.example.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xp.example.service.ExceptionService;
import org.xp.example.utils.BaseResp;
import org.xp.example.utils.ResultStatus;

import javax.annotation.Resource;


/**
 * @author xupeng
 * @Desc
 * @date 2020/7/8 11:05
 *
 *  * 参考： * @GitHub: https://github.com/vector4wang
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @Resource
    private ExceptionService exceptionService;

    @RequestMapping("/hello")
    public BaseResp<?> hello(@RequestParam("fz") int fz,
                             @RequestParam("fm") int fm){

        return new BaseResp<Double>(ResultStatus.SUCCESS,exceptionService.getResult(fz,fm));
    }
}
