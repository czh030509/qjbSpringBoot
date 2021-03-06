package com.zaihua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : zaihua.chen
 * @version : 1.0.0
 * @since : 2016/12/28 18:03
 */
@Controller
public class MainController {
    @RequestMapping("/get/1")
    public String getQuanjb(Model model) {
        return "quanjb";
    }

    @RequestMapping("/get/2/{code}")
    public String getCodes(@PathVariable("code") String code, Model model) {
        model.addAttribute("code", code);
        return "companies";
    }
}
