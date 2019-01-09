package com.mybatis.dao.db2;


import com.mybatis.bean.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentDao {

  @Select("select * from student")
  public List<Student> getAllStudent();

}
