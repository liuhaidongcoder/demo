package com.liuhaidongcoder.mybatis.mapper;

import com.liuhaidongcoder.mybatis.dao.Student;

import java.util.Map;

/**
 * @author Liu Haidong
 * @date 20/12/7
 */
public interface StudentMapper{
    Student get(int id);
    int insert(Student student);
    Student getByMap(Map<String,Object> map);
    Student getJoin(int id);
}
