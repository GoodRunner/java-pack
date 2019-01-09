## 记录一些问题

1. mybatis使用collection嵌套查询分页问题

   1.1 如果查询没有用到嵌套查询可以用`PageHelper`实现分页
    ```
    PagerHelper.startPage(1,3);
    List<Student> list = studentDao.queryAllStu();
    PageInfo<Student> pageInfo = new PageInfo(list);
    ```
    1.2 如果用需要嵌套查询来分页，可以在内存中操作（先查一张表，再查另一张表，内存中循环），也可以用`mybatis`分成两个`select`查询
    ```xml
      <resultMap id="ClazzResultMap" type="com.cn.hnust.pojo.ClazzEntity" >
        <id column="classID" property="clazzID" jdbcType="INTEGER" />
        <result column="className" property="clazzName" jdbcType="VARCHAR" />
        <collection property="studentList" column="classID" javaType="ArrayList" 
                    ofType="com.cn.hnust.pojo.StudentEntity" select="getStudentByClassID"/>
      </resultMap>
    
      <resultMap id="StudentResultMap" type="com.cn.hnust.pojo.StudentEntity">  
        <id property="stuID" column="stuID" />  
        <result property="stuName" column="stuName" />  
        <result property="stuAge" column="stuAge" />  
        <result property="stuAddress" column="stuAddress" />
      </resultMap>  
    
    <select id="getClassByID" resultMap="ClazzResultMap" parameterType="java.lang.Integer" >
        select classID,className
        from class_t
        where classID = #{clazzID}
    </select>
    
    <select id="getStudentByClassID" resultMap="StudentResultMap" parameterType="java.lang.Integer" >
        select stuID,stuName,stuAge,stuAddress,classID
        from student_t
        where classID = #{clazzID}
    </select>
    ```