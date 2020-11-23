package com.wozu.demo.soapDemo.service;


import com.wozu.soapdemo.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void intilialize() {

        User peter = new User();
        peter.setName("Peter");
        peter.setEmployeeId(1111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmployeeId(1111);
        sam.setSalary(12000);

        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmployeeId(1111);
        ryan.setSalary(12000);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);
    }

    public User getUsers(String name) {
        return users.get(name);
    }

}
