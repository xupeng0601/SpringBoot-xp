package org.xp.example.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xp.example.utils.BaseResp;
import org.xp.example.utils.ResultStatus;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xupeng
 * @Desc   当用户输入不合法的url时，返回标准结果(json字符串，而不是页面)
 * @date 2020/7/8 11:05
 * 参考：http://neverflyaway.iteye.com/blog/2301571  http://blog.csdn.net/u010935920/article/details/71024018
 * @CSDN: http://blog.csdn.net/qqhjqs?viewmode=contents
 * @BLOG: http://vector4wang.tk
 */
@ControllerAdvice(annotations = {Controller.class})
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 系统异常处理，比如：404,500
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseResp<?> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error("", e);
        BaseResp baseResp = new BaseResp();
        baseResp.setMessage(e.toString());
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            baseResp.setCode(ResultStatus.http_status_not_found.getErrorCode());
        } else {
            baseResp.setCode(ResultStatus.http_status_internal_server_error.getErrorCode());
        }
        baseResp.setData("");
        return baseResp;
    }
}
