package com.spring.departmentservice.departmentservice.service;

import com.oracle.tools.packager.Log;
import com.spring.departmentservice.departmentservice.entity.Department;
import com.spring.departmentservice.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department save(Department department) {
        Log.info("Inside save department method service");
        return departmentRepository.save(department);
    }

    public Optional<Department> findById(Long id) {
        Log.info("Inside get department method service");
        return departmentRepository.findById(id);
    }
}
