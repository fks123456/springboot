package com.fks.test;


import com.fks.config.MainConfig;
import com.fks.domain.User;
import com.fks.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MainConfig.class)
public class MDTest {


    @Autowired
    private IUserService userService;
    @Autowired
    private ApplicationContext ac;

    @Test
    public void test() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String str : beanDefinitionNames) {
            System.out.println(str);
        }
    }

    @Test
    public void testSelectUsers() {
        List<User> users = userService.selectAllUser();

        for(User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUsers() {
        List<User> users = userService.findAllUser();

        for(User user : users) {
            System.out.println(user);
        }
    }

}
