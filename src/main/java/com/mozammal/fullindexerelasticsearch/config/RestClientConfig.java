package com.mozammal.fullindexerelasticsearch.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;

@Configuration
public class RestClientConfig extends AbstractElasticsearchConfiguration {

  Logger LOGGER = LoggerFactory.getLogger(RestClientConfig.class);

  @Value("${spring.elasticsearch.rest.uris}")
  private String url;


  @Override
  @Bean(name = "elasticRestClient")
  public RestHighLevelClient elasticsearchClient() {
    LOGGER.info("url {}", url);
    final ClientConfiguration clientConfiguration =
        ClientConfiguration.builder().connectedTo(url.substring(7)).build();
    return RestClients.create(clientConfiguration).rest();
  }
}
