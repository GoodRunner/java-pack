package com.mybatis.service;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.mybatis.bean.User;
import com.mybatis.dao.db2.StudentDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 用户的service类
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-12-11 15:41
 */
@Service
public class UserService {

  @Autowired
  private StudentDao studentDao;

  public void uploadUser(MultipartFile file) {

    try {
      ExcelReader reader = ExcelUtil.getReader(file.getInputStream());
      List<User> rows = reader.read(1, 2, 1500, User.class);

      List<List<User>>  subLists = groupList(rows, 1000);

      ExecutorService pool = Executors.newFixedThreadPool(subLists.size() + 1);
      for (List<User> subList : subLists) {
        InserUserTask inserUserTask = new InserUserTask(subList, studentDao);
        pool.submit(inserUserTask);
      }
      System.out.println("提交了所有任务！");

    } catch (IOException e) {
      e.printStackTrace();
    }



  }

  /**
   * 根据参数，自行决定每个子list的大小
   * @param list
   * @param splitSize
   * @return
   */
  public static List<List<User>> groupList(List<User> list,int splitSize) {
    List<List<User>> listGroup = new ArrayList<List<User>>();
    int listSize = list.size();
    //子集合的长度
    int toIndex = splitSize;
    for (int i = 0; i < list.size(); i += toIndex) {
      if (i + toIndex > listSize) {
        toIndex = listSize - i;
      }
      List<User> newList = list.subList(i, i + toIndex);
      listGroup.add(newList);
    }
    return listGroup;
  }

}