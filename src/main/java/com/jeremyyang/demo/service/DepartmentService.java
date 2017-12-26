package com.jeremyyang.demo.service;

import com.jeremyyang.demo.dao.DepartmentBeanMapper;
import com.jeremyyang.demo.entity.DepartmentBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("DepartmentService")
@Transactional
public class DepartmentService {

    @Autowired
    private DepartmentBeanMapper departmentMapper;

    public List<DepartmentBean> getAllDepartments() {
        return this.departmentMapper.getAll();
    }

}
