package com.mybatis.service;

import com.mybatis.dao.db2.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

  @Autowired
  private StudentDao studentDao;

  public List getStu() {
    return studentDao.getAllStudent();
  }

}
