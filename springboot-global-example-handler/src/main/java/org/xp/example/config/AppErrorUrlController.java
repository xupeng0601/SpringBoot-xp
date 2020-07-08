package org.xp.example.config;


import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xp.example.utils.BaseResp;
import org.xp.example.utils.ResultStatus;


/**
 * @author xupeng
 * @Desc   当用户输入不合法的url时，返回标准结果(json字符串，而不是页面)
 * @date 2020/7/8 11:05
 */
@RestController
public class AppErrorUrlController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public BaseResp<?> error() {
        return new BaseResp<String>(ResultStatus.error_invalid_argument,ResultStatus.error_invalid_argument.name());
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
