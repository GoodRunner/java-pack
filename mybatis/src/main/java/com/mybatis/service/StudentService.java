package com.mybatis.service;

import com.mybatis.bean.Student;
import com.mybatis.dao.db2.StudentDao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  @Autowired
  private StudentDao studentDao;

  public List getStu() {
    return studentDao.getAllStudent();
  }

  public boolean updateStu()throws Exception {

    Student s = new Student();
    s.setSname("小刚");
    s.setAge(93);
    for (int i = 0; i < 10000; i++) {
      studentDao.updateStu(s);
    }
    return true;
  }

  public void insertStu() {

    List<Student> list = new ArrayList<>();

    for (int i = 4; i < 5999 ; i++) {
      Student s = new Student();
      s.setId(i);
      s.setSname("小" + i);
      s.setAge(i + 4);
      list.add(s);
    }
    studentDao.insertStu(list);
  }

}
