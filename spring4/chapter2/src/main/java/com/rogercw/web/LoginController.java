package com.rogercw.web;

import com.rogercw.domain.User;
import com.rogercw.domain.vo.LoginCommond;
import com.rogercw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 1 on 2018/4/4.
 */
@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/index.html")
    public String loginPage(){
        return "login";
    }

    /**
     * 登录检查
     * @param request
     * @param loginCommond
     * @return
     */
    @RequestMapping(value = "/loginCheck.html",method = RequestMethod.POST)
    public ModelAndView loginCheck(HttpServletRequest request,
                                   LoginCommond loginCommond){
        //根据用户名和密码匹配用户
        boolean isValidUser = userService.hasMatchUser(loginCommond.getUserName(), loginCommond.getPassword());
        if(!isValidUser){
            //登录用户不存在,
            return new ModelAndView("login","error","用户名或密码错误");
        }else{
            //更新用户信息
            User user=userService.findUserByUserName(loginCommond.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastLogin(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            System.out.println(user.getUserName());
            return new ModelAndView("main");
        }
    }

    //**************************************************

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
