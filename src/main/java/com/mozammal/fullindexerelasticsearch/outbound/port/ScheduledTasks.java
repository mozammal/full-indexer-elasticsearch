package com.mozammal.fullindexerelasticsearch.outbound.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;
import com.mozammal.fullindexerelasticsearch.model.api.strategy.RestApiCallStrategy;
import com.mozammal.fullindexerelasticsearch.model.api.strategy.SimpleRestApiCallFactory;
import com.mozammal.fullindexerelasticsearch.model.repository.DocumentContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ScheduledTasks {

  @Value("${news.api.key}")
  private String apiKey;

  private final DocumentContentRepository documentContentRepository;

  @Autowired
  public ScheduledTasks(DocumentContentRepository documentContentRepository) {
    this.documentContentRepository = documentContentRepository;
  }

  @Scheduled(fixedRate = 86400000)
  public void fetchDocumentsFromNewsAPI() throws JsonProcessingException {
    SimpleRestApiCallFactory simpleRestApiCallFactory = new SimpleRestApiCallFactory();
    RestApiCallStrategy newsAPIsStrategy = simpleRestApiCallFactory.createRestApiCall("newsAPIs", apiKey);
    List<ArticleDocument> articleDocuments = newsAPIsStrategy.call();
    articleDocuments.forEach(article -> documentContentRepository.save(article));
    log.info("articles: {}", articleDocuments.size());
  }
}
