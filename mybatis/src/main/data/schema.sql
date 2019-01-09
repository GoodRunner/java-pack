use mytest;

create table book
(
   id            int not null AUTO_INCREMENT COMMENT '主键',
   name          varchar(50) COMMENT '书名',
   author        varchar (100) COMMENT '作者',
   publishDate   timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
   primary key (id)

)DEFAULT CHARSET=utf8;
alter table book COMMENT '图书信息';


use hello;

create table student
(
   id            int not null AUTO_INCREMENT COMMENT '主键',
   sname         varchar(50) COMMENT '学生名',
   age           int COMMENT '年龄',
   primary key (id)

)DEFAULT CHARSET=utf8;
alter table student COMMENT '学生信息';
