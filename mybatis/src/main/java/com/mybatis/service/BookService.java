package com.mybatis.service;

import com.mybatis.dao.db1.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

  @Autowired
  private BookDao bookDao;


  public List getBook(){
    return bookDao.getBookList();
  }

}
