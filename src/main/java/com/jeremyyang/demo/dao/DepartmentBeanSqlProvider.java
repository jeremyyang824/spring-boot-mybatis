package com.jeremyyang.demo.dao;

import com.jeremyyang.demo.entity.DepartmentBean;
import org.apache.ibatis.jdbc.SQL;

public class DepartmentBeanSqlProvider {

    public String insertSelective(DepartmentBean record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("department");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getDepartmentcode() != null) {
            sql.VALUES("departmentCode", "#{departmentcode,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartmentname() != null) {
            sql.VALUES("departmentName", "#{departmentname,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(DepartmentBean record) {
        SQL sql = new SQL();
        sql.UPDATE("department");
        
        if (record.getDepartmentcode() != null) {
            sql.SET("departmentCode = #{departmentcode,jdbcType=VARCHAR}");
        }
        
        if (record.getDepartmentname() != null) {
            sql.SET("departmentName = #{departmentname,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}