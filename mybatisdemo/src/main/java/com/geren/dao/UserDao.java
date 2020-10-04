package com.geren.dao;

import com.geren.domian.QueryVo;
import com.geren.domian.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <一句话功能简述><br>
 * <>
 *
 * @author $ {USER}
 * @create $ {DATE}
 * @since 1.0.0
 */

@Mapper
public interface UserDao {

    @Select("select * from manage_student;")
    List<User> findAll();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User findById(Integer userId);

    List<User> findUserByVo(QueryVo vo);

    List<User> findUserList(User user);

    int findToal();
}
