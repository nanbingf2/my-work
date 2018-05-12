package com.rogercw.web;

import com.rogercw.domain.User;
import com.rogercw.domain.vo.UserCommand;
import com.rogercw.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by 1 on 2018/4/16.
 */
@Controller
public class LoginController {
    //注入UserService
    @Resource
    private UserService userService;

    @RequestMapping(value = {"/","/index.html"})
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck",method = RequestMethod.POST)
    public ModelAndView loginCheck(UserCommand userCommand, HttpServletRequest request){
        if(!userService.hasUserMatch(userCommand.getUserName(),userCommand.getPassword())){
            //登录用户不存在
            return new ModelAndView("login","error","用户名或密码错误");
        }else{
            User user=userService.findUserByUserName(userCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastLogin(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user",user);
            return new ModelAndView("main");
        }
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
