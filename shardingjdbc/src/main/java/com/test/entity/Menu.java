package com.test.entity;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-03 14:34
 */
public class Menu {

  private Long id;

  private String menu_name;

  private String menuUrl;

  public void setId(Long id) {
    this.id = id;
  }

  public void setMenuName(String menuName) {
    this.menu_name = menuName;
  }

  public void setMenuUrl(String menuUrl) {
    this.menuUrl = menuUrl;
  }

  public Long getId() {
    return id;
  }

  public String getMenuName() {
    return menu_name;
  }

  public String getMenuUrl() {
    return menuUrl;
  }

}