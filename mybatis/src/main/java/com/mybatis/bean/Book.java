package com.mybatis.bean;

import java.util.Date;

/**
 * 图书信息
 */
public class Book {

  private Integer id;
  private String name;//书名
  private String author;//作者
  private Date publishDate;//发布日期

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getPublishDate() {
    return publishDate;
  }

  public void setPublishDate(Date publishDate) {
    this.publishDate = publishDate;
  }
}
