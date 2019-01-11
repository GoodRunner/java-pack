package com.mybatis.service;

import com.mybatis.bean.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {

  @Autowired
  private BookService bookService;

  @Test
  public void testBook() {
    List<Book> list = bookService.getBook();
    System.out.println(list);
    Assert.assertNotNull(list);
  }

}
