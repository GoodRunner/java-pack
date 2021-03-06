package com.mylog.service;

import lombok.extern.slf4j.Slf4j;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2021-02-04 11:02
 */
@Service
@Slf4j(topic = "StudentService")
public class StudentService {

  public Map<String, Object> getStuInfo(String name) {

    log.info("StudentService getStuInfo  param:{}", name);

    Map<String, Object> m = new HashMap<>();

    m.put("name", name);
    m.put("age", "19");
    m.put("hight", "174cm");
    m.put("wight", "62kg");

    return m;
  }

}