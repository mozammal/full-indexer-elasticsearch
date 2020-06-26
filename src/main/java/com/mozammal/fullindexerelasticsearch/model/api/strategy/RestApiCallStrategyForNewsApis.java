package com.mozammal.fullindexerelasticsearch.model.api.strategy;

import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;
import com.mozammal.fullindexerelasticsearch.model.ResponseArticlesDtoFromNewsAPI;

import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class RestApiCallStrategyForNewsApis implements RestApiCallStrategy {

  private String apiKey;

  private static final String URL_NEWS_API = "http://newsapi.org/v2/everything";

  public RestApiCallStrategyForNewsApis(String apiKey) {
    this.apiKey = apiKey;
  }

  @Override
  public List<ArticleDocument> call() {
    LocalDate currentDate = LocalDate.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String curDateInStringFormat = currentDate.format(dateTimeFormatter);
    String query = "beautiful place";
    String urlToFetchData =
        URL_NEWS_API
            + "?q="
            + query
            + "&from="
            + curDateInStringFormat
            + "&sortBy=publishedAt&apiKey="
            + apiKey;

    ResponseArticlesDtoFromNewsAPI responseArticlesDtoFromNewsAPI =
        new RestTemplate().getForObject(urlToFetchData, ResponseArticlesDtoFromNewsAPI.class);

    List<ArticleDocument> articleDocuments =
        responseArticlesDtoFromNewsAPI.getArticles().stream()
            .map(article -> new ArticleDocument(article))
            .collect(Collectors.toList());
    return articleDocuments;
  }
}
