package com.test;

import com.geren.dao.UserDao;
import com.geren.domian.QueryVo;
import com.geren.domian.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

public class MyBatisTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init()throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }


    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void run(){
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setAge(39);
        user.setSname("x招");
        userDao.saveUser(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setSname("转身");
        user.setAge(30);
        user.setSid(8);
        userDao.updateUser(user);
    }

    @Test
    public void testDelete(){
        userDao.deleteUser(7);
    }

    @Test
    public void testFindOne(){
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindByVo(){
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setSname("%孩%");
        vo.setUser(user);
        List<User> users = userDao.findUserByVo(vo);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindList(){
        User user = new User();
        user.setSname("%孩%");
        List<User> list = userDao.findUserList(user);

        for (User user1 : list) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindToal(){
        int count = userDao.findToal();
        System.out.println(count);
    }












}
