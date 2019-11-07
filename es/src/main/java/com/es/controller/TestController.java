package com.es.controller;

import io.searchbox.client.JestClient;
import io.searchbox.indices.template.GetTemplate;
import com.es.service.MainService;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-06-19 09:44
 */
@RestController
@RequestMapping("/api")
public class TestController {

  @Autowired
  private MainService mainService;

  @Autowired
  private JestClient jestClient;

  @RequestMapping("/list")
  public List getList() throws IOException {

    GetTemplate gt = new GetTemplate.Builder("GET").build();

    jestClient.execute(gt);

    return null;

  }

}