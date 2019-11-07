package com.es.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: config es
 * @author: victor
 * @email: wupeiqun@xdf.cn
 * @create: 2019-06-19 09:45
 */
@Configuration
public class EsConfig {

  @Bean
  public static JestClient getJestClient() {
    JestClientFactory factory = new JestClientFactory();
    factory.setHttpClientConfig(new HttpClientConfig
            .Builder("http://127.0.0.1:9200")
            .multiThreaded(true)
            .readTimeout(10000)
            .build());
    JestClient client = factory.getObject();
    return client;
  }

}