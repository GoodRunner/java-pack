package com.es.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 文章实体
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-06-19 09:49
 */
public class Article implements Serializable {

  private Integer id;

  private String title;

  private String content;

  private Date date;

  private Long user_id;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}