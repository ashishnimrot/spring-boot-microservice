package com.spring.user.service;

import com.spring.user.VO.Department;
import com.spring.user.VO.ResponseTemplateVO;
import com.spring.user.entiry.User;
import com.spring.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public User save(User user) {
        return repository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) throws Exception {
        ResponseTemplateVO vo = new ResponseTemplateVO();

        Optional<User> optionalUser = repository.findById(id);
        User user;
        if(!optionalUser.isPresent()){
            throw new Exception("User id not present in system!");
        }

        user = optionalUser.get();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }
}
