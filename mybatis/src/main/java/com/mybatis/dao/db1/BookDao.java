package com.mybatis.dao.db1;

import com.mybatis.bean.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao {

  @Select("select * from book")
  public List<Book> getBookList();

}
