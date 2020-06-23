package com.mozammal.fullindexerelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableElasticsearchRepositories
public class FullIndexerElasticsearchApplication {

  public static void main(String[] args) {
    SpringApplication.run(FullIndexerElasticsearchApplication.class, args);
  }
}
