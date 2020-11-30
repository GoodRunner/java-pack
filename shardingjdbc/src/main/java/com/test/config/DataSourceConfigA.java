package com.test.config;

import io.shardingsphere.core.api.MasterSlaveDataSourceFactory;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import com.alibaba.druid.pool.DruidDataSource;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-03 14:19
 */
//@Configuration
  @Component
@MapperScan(basePackages = "com.test.dao.hl", sqlSessionFactoryRef = "sqlSessionFactoryHl")
public class DataSourceConfigA {



  @Value("${datasources.driver}")
  private String driver;
  @Value("${datasources.hl.master.url}")
  private String masterUrl;
  @Value("${datasources.hl.master.username}")
  private String masterusername;
  @Value("${datasources.hl.master.password}")
  private String masterpasswd;

  @Value("${datasources.hl.slave.url}")
  private String slaveUrl;
  @Value("${datasources.hl.slave.username}")
  private String slaveusername;
  @Value("${datasources.hl.slave.password}")
  private String slavepasswd;

  @Bean("hl_ds_master")
  @ConfigurationProperties(prefix = "datasources.hl.master")
  public DataSource getMasterDs() {
    // 配置主库
    DataSource ds = new DruidDataSource();
     //DataSource ds = DataSourceBuilder.create().build();
    return ds;
  }

  @Bean("hl_ds_slave0")
  @ConfigurationProperties(prefix = "datasources.hl.slave")
  public DataSource getSlaveDs() {
    // 配置第一个从库
    DataSource ds = new DruidDataSource();
    //DataSource ddd =  DataSourceBuilder.create().build();
    return ds;
  }

  /**
   * 配置hl的数据源
   * @return
   */
  @Bean("dataSourceHl")
  //@Primary
  public DataSource getDataSource(@Qualifier("hl_ds_master") DataSource master,
                                  @Qualifier("hl_ds_slave0") DataSource slave) throws SQLException {
    // 配置数据源
    Map<String, DataSource> dataSourceMap = new HashMap<>();
    dataSourceMap.put("hl_ds_master", master);
    dataSourceMap.put("hl_ds_slave0", slave);

    // 配置读写分离规则
    MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("hl_ds_master_slave", "hl_ds_master", Arrays.asList("hl_ds_slave0"));


    try {
      DataSource dataSource =
              MasterSlaveDataSourceFactory.createDataSource(
                      dataSourceMap,
                      masterSlaveRuleConfig,
                      new ConcurrentHashMap<>());
      return dataSource;
    } catch (Exception e) {
      System.out.println("系统错误");
      throw e;
    }
  }

  @Bean("sqlSessionFactoryHl")
  @Primary
  public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSourceHl") DataSource dataSource)throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean(name = "sqlSessionTemplateHl")
  @Primary
  public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactoryHl") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }


}