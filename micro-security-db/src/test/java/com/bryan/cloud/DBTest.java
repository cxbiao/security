package com.bryan.cloud;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@SpringBootTest
public class DBTest {


    @Test
    public void password(){
        String encode = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456");
        System.out.println(encode);

    }
}
