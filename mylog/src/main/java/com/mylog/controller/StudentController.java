package com.mylog.controller;

import com.mylog.service.StudentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-02-04 16:57
 */
@RestController
@RequestMapping("/test/log")
public class StudentController {

  @Autowired
  private StudentService studentService;


  @RequestMapping(value = "/stu-info", method = RequestMethod.GET)
  public Map<String, Object> getInfo(@RequestParam("name") String name) {

    Map<String, Object> stuInfo = studentService.getStuInfo(name);

    return stuInfo;

  }

}