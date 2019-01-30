## 记一次mysql死锁排查

场景：
> 线上考试系统，在考试完之后，需要批量更新用户的考试时间。

更新表的语句是这个：

```xml
update score set cost_timt = cost_time + #{costTime} where exam_id = #{examId} and section_code = #{sectionCode}
```

查明：在update语句中如果没有使用索引的话使用的是表锁。

期间一直有程序使用行锁（事务中，事务比较大），导致表锁等待超时。