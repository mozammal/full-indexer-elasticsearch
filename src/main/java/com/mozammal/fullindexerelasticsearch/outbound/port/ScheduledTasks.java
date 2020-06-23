/*
package com.mozammal.fullindexerelasticsearch.outbound.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;
import com.mozammal.fullindexerelasticsearch.model.ResponseArticlesDtoFromNewsAPI;
import com.mozammal.fullindexerelasticsearch.model.repository.DocumentContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ScheduledTasks {

  @Value("${news.api.key}")
  private String apiKey;

  private static final String URL_NEWS_API = "http://newsapi.org/v2/everything";

  private final RestTemplate restTemplate;

  private final DocumentContentRepository documentContentRepository;

  @Autowired
  public ScheduledTasks(
      RestTemplate restTemplate, DocumentContentRepository documentContentRepository) {
    this.restTemplate = restTemplate;
    this.documentContentRepository = documentContentRepository;
  }

  @Scheduled(fixedRate = 86400000)
  public void fetchDocumentsFromNewsAPI() throws JsonProcessingException {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String curDateInStringFormat = currentDate.format(dateTimeFormatter);
    String query = "love";
    String urlToFetchData =
        URL_NEWS_API
            + "?q="
            + query
            + "&from="
            + curDateInStringFormat
            + "&sortBy=publishedAt&apiKey="
            + apiKey;

    ResponseArticlesDtoFromNewsAPI responseArticlesDtoFromNewsAPI =
        restTemplate.getForObject(urlToFetchData, ResponseArticlesDtoFromNewsAPI.class);

    List<ArticleDocument> articleDocuments =
        responseArticlesDtoFromNewsAPI.getArticles().stream()
            .map(article -> new ArticleDocument(article))
            .collect(Collectors.toList());
    articleDocuments.forEach(article -> documentContentRepository.save(article));
    log.info("articles: {}", responseArticlesDtoFromNewsAPI.getArticles().size());
  }
}
*/
