package com.mozammal.fullindexerelasticsearch.model.api.strategy;

import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;
import com.mozammal.fullindexerelasticsearch.model.ResponseArticlesDtoFromNewsAPI;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RestApiCallStrategyForNewsApis implements RestApiCallStrategy {

    private String apiKey;

    private static final String URL_NEWS_API = "https://newsapi.org/v2/everything";

    public RestApiCallStrategyForNewsApis(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public List<ArticleDocument> call() throws UnsupportedEncodingException {
        LocalDate currentDate = LocalDate.now().minusDays(1);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String curDateInStringFormat = currentDate.format(dateTimeFormatter);
        String query = "beautiful place";
        String queryURL =
                URL_NEWS_API
                        + "?q="
                        + URLEncoder.encode(query, StandardCharsets.UTF_8.toString())
                        + "&from="
                        + curDateInStringFormat
                        + "&apiKey=" + apiKey;
        log.info("query url: {}", queryURL);

        ResponseArticlesDtoFromNewsAPI responseArticlesDtoFromNewsAPI =
                new RestTemplate().getForObject(queryURL, ResponseArticlesDtoFromNewsAPI.class);

        List<ArticleDocument> articleDocuments =
                responseArticlesDtoFromNewsAPI.getArticles().stream()
                        .map(article -> new ArticleDocument(article))
                        .collect(Collectors.toList());
        return articleDocuments;
    }
}
