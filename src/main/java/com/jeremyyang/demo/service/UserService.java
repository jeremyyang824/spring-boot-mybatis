package com.jeremyyang.demo.service;

import javax.transaction.Transactional;
import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeremyyang.demo.dao.UserDao;
import com.jeremyyang.demo.entity.UserBean;

@Service("UserService")
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<UserBean> getUsers() {
        return this.userDao.getAll();
    }

    public PageInfo<UserBean> findByPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<UserBean> list = userDao.findByPage();
        return new PageInfo<>(list);
    }

    public UserBean getUserById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id: null");
        }
        return this.userDao.getOne(id);
    }
}
