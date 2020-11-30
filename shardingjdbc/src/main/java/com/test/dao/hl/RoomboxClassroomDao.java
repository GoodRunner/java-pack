package com.test.dao.hl;

import com.test.entity.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoomboxClassroomDao {

  @Select("select * from rb_classroom where classroom_id = 4562 ")
  public Classroom getroom();

}
