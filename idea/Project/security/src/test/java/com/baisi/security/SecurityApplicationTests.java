package com.baisi.security;

import com.baisi.security.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.spec.PSource;

@SpringBootTest
class SecurityApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
        userService.getAll().forEach(System.out::println);
    }

}
