package com.zk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zk.service.ZkService;


/**
 * @description: d
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-12-10 16:39
 */
@RestController
@RequestMapping("/api")
public class IndexController {

  @Autowired
  private ZkService zkService;

  @RequestMapping("/hello")
  public String hello() {
    return zkService.info();
  }

  @RequestMapping("/select")
  public String select()throws Exception {
    return zkService.masterSelect();
  }

  @RequestMapping("/lock")
  public String lock()throws Exception {
    return zkService.distriuteLock();
  }

}