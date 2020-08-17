package cn.ming.controller;

import cn.ming.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ASUS on 2020/8/14.
 */

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello swagger!";
    }

    //只要我们的接口中返回值存在实体类，它就会被扫描到实体类
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    //Operation接口 放在方法上，不是类上
    @ApiOperation("Hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名")String username){
        return "hello"+username;
    }
}
