package com.mybatis.dao.db2;


import com.mybatis.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentDao {

  @Select("select * from student")
  public List<Student> getAllStudent();

  @Update("update student set age = #{age} where sname = #{sname} ")
  public Integer updateStu(Student s);

  @Insert("<script> replace into student(id,sname,age) values " +
          "<foreach collection='array' item='stu' separator=','>" +
          "(#{stu.id},#{stu.sname},#{stu.age})</foreach>\n" +
          "</script>")
  public void insertStu(@Param("array") List<Student> array);

}
