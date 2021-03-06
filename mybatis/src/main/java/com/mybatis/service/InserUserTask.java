package com.mybatis.service;

import com.mybatis.bean.User;
import com.mybatis.dao.db2.StudentDao;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-12-11 17:28
 */
public class InserUserTask implements Runnable {

  private List<User> list;


  private StudentDao studentDao;

  public InserUserTask(List<User> list, StudentDao studentDao) {
      this.list = list;
      this.studentDao = studentDao;
  }

  @Override
  public void run() {
    studentDao.insertS(list);
  }
}