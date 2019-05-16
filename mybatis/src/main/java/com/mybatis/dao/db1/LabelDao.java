package com.mybatis.dao.db1;

import com.mybatis.bean.Label;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LabelDao {

  @Insert("insert into label" +
          "(id, key_code, tag_zh_name , tag_en_name , description , fun_code , parent_id , level , sort , type_code , " +
          "type_desc , is_must , is_multi , used , create_date , update_date , creator_id , updater_id) " +
          "values(#{id}, #{key_code}, #{tag_zh_name} , #{tag_en_name} , #{description} , #{fun_code} , #{parent_id} , " +
          "#{level} , #{sort} , #{type_code} , #{type_desc} , #{is_must} ,#{is_multi} , #{used} , #{create_date} , " +
          "#{update_date} , #{creator_id} , #{updater_id}) ")
  public Integer insertLabel(Label label);

}
