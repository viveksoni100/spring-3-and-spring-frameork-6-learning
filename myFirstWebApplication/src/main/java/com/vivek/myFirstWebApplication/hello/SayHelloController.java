package com.vivek.myFirstWebApplication.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @ResponseBody   // will return as is to the browser
    @RequestMapping("/say-hello")
    public String sayHello() {
        return "Hello! what are you learning today?";
    }

    @ResponseBody
    @RequestMapping("/say-hello-html")
    public String sayHelloHtml() {
        return "<html><body>A Halooo Padi...!</body></html>";
    }

    @RequestMapping("/say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";
    }

}
