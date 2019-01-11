package com.mybatis.service;

import com.mybatis.bean.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTests {

  @Autowired
  private StudentService studentService;

  @Test
  public void testStudent() {
    List<Student> list = studentService.getStu();
    Assert.assertNotNull(list);
  }

}
