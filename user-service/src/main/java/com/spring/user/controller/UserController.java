package com.spring.user.controller;

import com.oracle.tools.packager.Log;
import com.spring.user.VO.ResponseTemplateVO;
import com.spring.user.entiry.User;
import com.spring.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/")
    public User save(@RequestBody User user){
        Log.info("Inside save user method user controller");
        return userService.save(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long id) throws Exception {
        Log.info("Inside get user method user controller");
        return userService.getUserWithDepartment(id);
    }

}
