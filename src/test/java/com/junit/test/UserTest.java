package com.junit.test;

import dao.UserMapper;
import entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01() {
        User user = userMapper.selectByPrimaryKey(2L);
        System.out.println(user);
    }


}
