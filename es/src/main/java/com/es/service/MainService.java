package com.es.service;

import com.es.entity.Article;
import com.google.common.collect.Lists;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-06-19 09:45
 */
@Service
public class MainService {


  public List searchList(String str) {

    Iterable<Article> its =  null;

    return Lists.newArrayList(its);

  }

}