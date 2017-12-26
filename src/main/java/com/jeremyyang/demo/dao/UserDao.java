package com.jeremyyang.demo.dao;

import java.util.List;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import com.jeremyyang.demo.entity.UserBean;

@Mapper
public interface UserDao {

    //@Select("SELECT * FROM user")
    List<UserBean> getAll();

    Page<UserBean> findByPage();

    //@Select("SELECT * FROM user WHERE id=#{id}")
    UserBean getOne(Long id);

    //@Insert("INSERT INTO user(name, password, lastLoginTime) VALUES(#{name}, #{password}, #{lastLoginTime})")
    void insert(UserBean user);

    //@Update("UPDATE user SET name=#{name}, password=#{password}, lastLoginTime=#{lastLoginTime} WHERE id=#{id}")
    void update(UserBean user);

    //@Delete("DELETE user WHERE id=#{id}")
    void delete(Long id);
}
