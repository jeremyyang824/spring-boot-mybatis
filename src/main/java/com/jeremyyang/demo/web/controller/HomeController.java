package com.jeremyyang.demo.web.controller;

import com.github.pagehelper.PageInfo;
import com.jeremyyang.demo.entity.UserBean;
import com.jeremyyang.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private final static int pageSize = 2;

    @Autowired
    private UserService userService;

    //@RequestMapping(method = RequestMethod.GET, path = "/index/{name}") -> @PathVariable
    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String Index(@RequestParam(value = "name", required = false) String name) {
        return "Hello World" + (!StringUtils.isEmpty(name) ? ": " + name : "") + "!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public @ResponseBody
    PageInfo<UserBean> GetUsers(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page) {
        // return userService.getUsers();
        return userService.findByPage(page, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public UserBean GetUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }
}
