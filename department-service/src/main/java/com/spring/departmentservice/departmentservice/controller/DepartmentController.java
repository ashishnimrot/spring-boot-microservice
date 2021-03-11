package com.spring.departmentservice.departmentservice.controller;

import com.oracle.tools.packager.Log;
import com.spring.departmentservice.departmentservice.entity.Department;
import com.spring.departmentservice.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department save(@RequestBody Department department){
        Log.info("Inside save department method department controller");
        return departmentService.save(department);
    }

    @GetMapping("/{id}")
    public Optional<Department> show(@PathVariable("id") Long id){
        Log.info("Inside get department method department controller");
        return departmentService.findById(id);
    }

}
