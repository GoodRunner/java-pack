package com.es.controller;

import io.searchbox.client.JestClient;
import io.searchbox.indices.template.GetTemplate;
import com.es.service.MainService;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @RequestMapping(value = "/list/haha/{id}/{method}", method = RequestMethod.DELETE)
  public List getList(@PathVariable(name = "id", required = true) String id , @PathVariable(name = "method", required = true) String method) throws IOException {

    //GetTemplate gt = new GetTemplate.Builder("GET").build();

    //jestClient.execute(gt);

    System.out.println(id+ "  " + method);

    return Collections.EMPTY_LIST;

  }

}