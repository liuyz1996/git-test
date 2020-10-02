package com.spring.demo1;


import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@Controller("user")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    public void Hello() {
        System.out.println("你好");
        dao.show();
    }



}
