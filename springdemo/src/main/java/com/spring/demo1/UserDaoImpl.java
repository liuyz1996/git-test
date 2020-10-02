package com.spring.demo1;

import org.springframework.stereotype.Repository;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@Repository
public class UserDaoImpl implements UserDao{

    public void show() {
        System.out.println("Dao");
    }
}
