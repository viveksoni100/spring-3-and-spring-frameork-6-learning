package com.vivek.myFirstWebApplication.login;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login(@RequestParam(name = "name") String name, ModelMap model) {
        log.info("Name is : {} ", name);
        model.put("name", name);
        return "login";
    }

}
