package com.os.mywebservice.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {

    @GetMapping("/welcome")
    public String sayHello(Model model){
        model.addAttribute("theDate",new java.util.Date());
        return "hello-world";
    }

}
