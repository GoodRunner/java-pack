package com.mybatis.controller;


import com.mybatis.service.BookService;
import com.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/data")
public class MultiDataSourceController {

  @Autowired
  private StudentService studentService;

  @Autowired
  private BookService bookService;

  @RequestMapping("/list")
  public Object getData() {
    List list = studentService.getStu();

    List blist = bookService.getBook();

    Map map = new HashMap();

    map.put("stu", list);
    map.put("book", blist);

    return map;
  }

  @RequestMapping("/wait")
  public String waitUpdate() {

    try {
      studentService.updateStu();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "{\"hello\":\"world\"}";
  }

  @RequestMapping("/select")
  public String select() {

    studentService.insertStu();

    return "{\"hello\":\"world\"}";
  }

}
