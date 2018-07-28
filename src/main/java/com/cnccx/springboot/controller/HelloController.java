package com.cnccx.springboot.controller;

import com.cnccx.springboot.config.StudentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试控制器
 */
@Controller
public class HelloController {

    @Autowired
    private StudentProperties studentProperties;

    @Value("${name}")
    private String name;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;

    /*@RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }*/

    @RequestMapping("/hello1")
    @ResponseBody
    public String hello1(){
        return "姓名："+ name + "，年龄：" + age;
    }

    @RequestMapping("/hello2")
    @ResponseBody
    public String hello2(){
        return content;
    }

    @RequestMapping("/hello3")
    @ResponseBody
    public String hello3(){
        return "姓名："+studentProperties.getName()+", 年龄"+studentProperties.getAge();
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        model.addAttribute("now", sdf.format(new Date()));
        return "hello";
    }

}
