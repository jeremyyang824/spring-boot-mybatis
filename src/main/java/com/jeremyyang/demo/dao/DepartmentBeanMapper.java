package com.jeremyyang.demo.dao;

import com.jeremyyang.demo.entity.DepartmentBean;

public interface DepartmentBeanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DepartmentBean record);

    int insertSelective(DepartmentBean record);

    DepartmentBean selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DepartmentBean record);

    int updateByPrimaryKey(DepartmentBean record);
}