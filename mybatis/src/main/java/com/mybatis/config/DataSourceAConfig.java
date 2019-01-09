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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.mybatis.dao.db1", sqlSessionTemplateRef = "sqlSessionTemplate1")
public class DataSourceAConfig {

  /**
   * 配置数据源，.
   * @return
   */
  @Bean("dataSource1")
  @ConfigurationProperties(prefix = "spring.datasource.db1")
  @Primary
  public DataSource testDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean("sqlSessionFactory1")
  @Primary
  public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSource1") DataSource dataSource)throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
      org.apache.ibatis.session.Configuration config = new org.apache.ibatis.session.Configuration();
      config.setMapUnderscoreToCamelCase(true);//设置驼峰开启
    bean.setConfiguration(config);
    //bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/db1/*.xml"));
    return bean.getObject();
  }

  @Bean(name = "transactionManager1")
  @Primary
  public DataSourceTransactionManager testTransactionManager(@Qualifier("dataSource1") DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

  @Bean(name = "sqlSessionTemplate1")
  @Primary
  public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

}
