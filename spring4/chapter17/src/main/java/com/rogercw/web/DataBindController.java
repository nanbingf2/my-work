package com.rogercw.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 1 on 2018/4/23.
 * @PathVariable  @RequestHeader  @CookieValue的使用
 */
@Controller
public class DataBindController {

    private static final Log logger= LogFactory.getLog(DataBindController.class);

    @RequestMapping("/pathVariable/{userId}")
    public String pathVariable(@PathVariable("userId") String userId){
        logger.info(userId);
        return "test";
    }

    @RequestMapping("/requestHeader")
    public String requestHeader(@RequestHeader("User-Agent") String userAgent,
                @RequestHeader("Accept") String[] accepts){
        logger.info(userAgent);
        for (String accept : accepts) {
            logger.info(accept);
        }
        return "test";
    }


    @RequestMapping("/cookieValue")
    public String cookieValue(@CookieValue(value="JSESSIONID",required = false) String jsessionId){
        logger.info(jsessionId);
        return "test";
    }
}
