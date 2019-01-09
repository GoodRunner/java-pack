package com.mybatis.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.mybatis.dao.db2", sqlSessionTemplateRef = "sqlSessionTemplate2")
public class DataSourceBConfig {


  /**
   * 配置数据源，.
   * @return
   */
  @Bean("dataSource2")
  @ConfigurationProperties(prefix = "spring.datasource.db2")
  public DataSource testDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean("sqlSessionFactory2")
  public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource2") DataSource dataSource)throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean(name = "transactionManager2")
  public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSource2") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "sqlSessionTemplate2")
  public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory2") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }


}
