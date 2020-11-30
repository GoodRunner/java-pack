package com.test.dao.tb;


import com.test.entity.Menu;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MenuDao {

  @Select("select * from menu")
  public List<Menu> getMenu();

}
