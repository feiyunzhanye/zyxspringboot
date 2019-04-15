package com.ideal.zyxspringboot.controller;

import com.ideal.zyxspringboot.model.AyUser;
import com.ideal.zyxspringboot.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Resource
    private AyUserService ayUserService;

    @RequestMapping("/test")
    public String test(Model model){
        List<AyUser> ayUserList = ayUserService.findAll();
        model.addAttribute("users",ayUserList);
        return "ayUser";
    }
}
