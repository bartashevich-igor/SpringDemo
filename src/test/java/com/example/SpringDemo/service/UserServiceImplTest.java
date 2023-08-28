package com.example.SpringDemo.service;

import com.example.SpringDemo.model.User;
import com.example.SpringDemo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void create() {
        User user = new User();
        user.setPassword("Qwerty123!");
        String encodedPassword = "jf2w0jisdlfnweijdf0qjiedsolkfmwepofdjmsd";
        Mockito.doReturn(encodedPassword).when(passwordEncoder)
                .encode(user.getPassword());
        userService.create(user);
        Mockito.verify(userRepository).save(user);

        Assertions.assertEquals(encodedPassword, user.getPassword());
    }

    @Test
    void getCurrentUser() {
    }
}