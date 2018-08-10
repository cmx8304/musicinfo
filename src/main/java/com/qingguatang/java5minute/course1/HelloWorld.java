package com.qingguatang.java5minute.course1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cmx 2018/8/8.
 * @version 1.0
 */
@Controller
public class HelloWorld {

    @RequestMapping(value = "/eat")
    @ResponseBody
    public String hello(){
        String message = "Hello";
        return message;
    }
}
