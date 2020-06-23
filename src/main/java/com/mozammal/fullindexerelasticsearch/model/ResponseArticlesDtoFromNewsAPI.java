package com.mozammal.fullindexerelasticsearch.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ResponseArticlesDtoFromNewsAPI {
  private String status;

  private int totalResults;

  List<ArticleContent> articles;
}
