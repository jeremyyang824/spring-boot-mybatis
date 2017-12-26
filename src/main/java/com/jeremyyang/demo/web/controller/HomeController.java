package com.jeremyyang.demo.web.controller;

import com.github.pagehelper.PageInfo;
import com.jeremyyang.demo.entity.DepartmentBean;
import com.jeremyyang.demo.entity.UserBean;
import com.jeremyyang.demo.service.DepartmentService;
import com.jeremyyang.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    private final static int pageSize = 2;

    private final static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    //@RequestMapping(method = RequestMethod.GET, path = "/index/{name}") -> @PathVariable
    @RequestMapping(method = RequestMethod.GET, path = "/index")
    public String Index(@RequestParam(value = "name", required = false) String name) {
        String value = "Hello World" + (!StringUtils.isEmpty(name) ? ": " + name : "") + "!";
        logger.debug(value);
        return value;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/users")
    @ResponseBody
    public PageInfo<UserBean> GetUsers(@RequestParam(value = "page", required = true, defaultValue = "1") Integer page) {
        // return userService.getUsers();
        return userService.findByPage(page, pageSize);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public UserBean GetUser(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/departments")
    @ResponseBody
    public List<DepartmentBean> GetDepartments() {
        return departmentService.getAllDepartments();
    }
}
