package com.test.entity;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-03 14:32
 */
public class Classroom {

  private Long id;



  private Long classroomId;

  private String classroom_name;

  private String classCode;

  public void setClassroomId(Long classroomId) {
    this.classroomId = classroomId;
  }

  public void setClassroomName(String classroomName) {
    this.classroom_name = classroomName;
  }

  public void setClassCode(String classCode) {
    this.classCode = classCode;
  }

  public Long getClassroomId() {
    return classroomId;
  }

  public String getClassroomName() {
    return classroom_name;
  }

  public String getClassCode() {
    return classCode;
  }
}