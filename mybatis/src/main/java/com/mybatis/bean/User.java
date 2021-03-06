package com.mybatis.bean;

import java.util.Date;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-12-11 16:21
 */
public class User {

  private Integer id;

  private String email;

  private String classCode;

  private Integer schoolId;

  private Date createTime;

  private Date updateTime;

  public Integer getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getClassCode() {
    return classCode;
  }

  public Integer getSchoolId() {
    return schoolId;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }

  public void setSchoolId(Integer schoolId) {
    this.schoolId = schoolId;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}