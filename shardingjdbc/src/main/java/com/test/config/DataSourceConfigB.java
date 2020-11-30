package com.test.config;

import io.shardingsphere.core.api.MasterSlaveDataSourceFactory;
import io.shardingsphere.core.api.config.MasterSlaveRuleConfiguration;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2020-07-03 14:19
 */
@Configuration
@MapperScan(basePackages = "com.test.dao.tb", sqlSessionFactoryRef = "sqlSessionFactoryTb")
public class DataSourceConfigB {



  @Value("${datasources.driver}")
  private String driver;
  @Value("${datasources.tb.master.jdbc-url}")
  private String masterUrl;
  @Value("${datasources.tb.master.username}")
  private String masterusername;
  @Value("${datasources.tb.master.password}")
  private String masterpasswd;

  @Value("${datasources.tb.slave.jdbc-url}")
  private String slaveUrl;
  @Value("${datasources.tb.slave.username}")
  private String slaveusername;
  @Value("${datasources.tb.slave.password}")
  private String slavepasswd;

  @Bean("tb_ds_master")
  public DataSource dsMaster() {
    // 配置主库
    return DataSourceBuilder.create()
            .driverClassName(driver)
            .url(masterUrl)
            .username(masterusername)
            .password(masterpasswd)
            .build();
  }
  @Bean("tb_ds_slave0")
  public DataSource dsSlave() {
    // 配置第一个从库
    return DataSourceBuilder.create()
            .driverClassName(driver)
            .url(slaveUrl)
            .username(slaveusername)
            .password(slavepasswd)
            .build();
  }

  /**
   * 配置hl的数据源
   * @return
   */
  @Bean("dataSourceTb")
  public DataSource getDataSource(@Qualifier("tb_ds_master") DataSource master, @Qualifier("tb_ds_slave0") DataSource slave) throws SQLException {
    // 配置数据源
    Map<String, DataSource> dataSourceMap = new HashMap<>();
    dataSourceMap.put("tb_ds_master", master);
    dataSourceMap.put("tb_ds_slave0", slave);

    // 配置读写分离规则
    MasterSlaveRuleConfiguration masterSlaveRuleConfig = new MasterSlaveRuleConfiguration("tb_ds_master_slave", "tb_ds_master", Arrays.asList("tb_ds_slave0"));

    try {
      DataSource dataSource =
              MasterSlaveDataSourceFactory.createDataSource(
                      dataSourceMap,
                      masterSlaveRuleConfig,
                      new HashMap<>());
      return dataSource;
    } catch (SQLException e) {
      throw e;
    }
  }

  @Bean("sqlSessionFactoryTb")
  public SqlSessionFactory getSqlSessionFactory(@Qualifier("dataSourceTb") DataSource dataSource)throws Exception {
    SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
    bean.setDataSource(dataSource);
    return bean.getObject();
  }

  @Bean(name = "sqlSessionTemplateTb")
  public SqlSessionTemplate testSqlSessionTemplate(@Qualifier("sqlSessionFactoryTb") SqlSessionFactory sqlSessionFactory) throws Exception {
    return new SqlSessionTemplate(sqlSessionFactory);
  }

}