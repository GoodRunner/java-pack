package com.mybatis.bean;

import java.util.Date;

public class Label {
  private Integer id;
  private String key_code ;
  private String tag_zh_name ;
  private String tag_en_name ;
  private String  description ;
  private String  fun_code ;
  private String  parent_id ;
  private Integer level ;
  private Integer sort ;
  private String  type_code ;
  private String type_desc ;
  private Integer is_must ;
  private Short is_multi ;
  private Short  used ;
  private Date create_date ;
  private Date update_date ;
  private Integer creator_id ;
  private Integer updater_id ;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getKey_code() {
    return key_code;
  }

  public void setKey_code(String key_code) {
    this.key_code = key_code;
  }

  public String getTag_zh_name() {
    return tag_zh_name;
  }

  public void setTag_zh_name(String tag_zh_name) {
    this.tag_zh_name = tag_zh_name;
  }

  public String getTag_en_name() {
    return tag_en_name;
  }

  public void setTag_en_name(String tag_en_name) {
    this.tag_en_name = tag_en_name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFun_code() {
    return fun_code;
  }

  public void setFun_code(String fun_code) {
    this.fun_code = fun_code;
  }

  public String getParent_id() {
    return parent_id;
  }

  public void setParent_id(String parent_id) {
    this.parent_id = parent_id;
  }

  public Integer getLevel() {
    return level;
  }

  public void setLevel(Integer level) {
    this.level = level;
  }

  public Integer getSort() {
    return sort;
  }

  public void setSort(Integer sort) {
    this.sort = sort;
  }

  public String getType_code() {
    return type_code;
  }

  public void setType_code(String type_code) {
    this.type_code = type_code;
  }

  public String getType_desc() {
    return type_desc;
  }

  public void setType_desc(String type_desc) {
    this.type_desc = type_desc;
  }

  public Integer getIs_must() {
    return is_must;
  }

  public void setIs_must(Integer is_must) {
    this.is_must = is_must;
  }

  public Short getIs_multi() {
    return is_multi;
  }

  public void setIs_multi(Short is_multi) {
    this.is_multi = is_multi;
  }

  public Short getUsed() {
    return used;
  }

  public void setUsed(Short used) {
    this.used = used;
  }

  public Date getCreate_date() {
    return create_date;
  }

  public void setCreate_date(Date create_date) {
    this.create_date = create_date;
  }

  public Date getUpdate_date() {
    return update_date;
  }

  public void setUpdate_date(Date update_date) {
    this.update_date = update_date;
  }

  public Integer getCreator_id() {
    return creator_id;
  }

  public void setCreator_id(Integer creator_id) {
    this.creator_id = creator_id;
  }

  public Integer getUpdater_id() {
    return updater_id;
  }

  public void setUpdater_id(Integer updater_id) {
    this.updater_id = updater_id;
  }
}
