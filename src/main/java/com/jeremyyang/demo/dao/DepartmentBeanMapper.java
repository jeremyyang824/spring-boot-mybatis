package com.jeremyyang.demo.dao;

import com.jeremyyang.demo.entity.DepartmentBean;

import java.util.List;

public interface DepartmentBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentBean record);

    int insertSelective(DepartmentBean record);

    DepartmentBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepartmentBean record);

    int updateByPrimaryKey(DepartmentBean record);

    List<DepartmentBean> getAll();
}