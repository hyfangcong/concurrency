package com.imooc.concurrency;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: fangcong
 * @date: 2019/5/18
 */
@ResponseBody
@Controller
public class Test {
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
