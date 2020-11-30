package com.test.controller;

import com.test.dao.hl.RoomboxClassroomDao;
import com.test.dao.tb.MenuDao;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-03 14:40
 */
@RestController
@RequestMapping("/api/con")
public class TestController {

  @Autowired
  private RoomboxClassroomDao roomboxClassroomDao;

  @Autowired
  private MenuDao menuDao;

  @RequestMapping("/test")
  public Map<String, Object> test() {
    Map<String, Object> map = new HashMap<>();

//    map.put("A", roomboxClassroomDao.getroom());
//    map.put("B", menuDao.getMenu());

      return map;
  }

}