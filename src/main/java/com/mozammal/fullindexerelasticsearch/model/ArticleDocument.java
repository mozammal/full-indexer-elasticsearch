package com.mozammal.fullindexerelasticsearch.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Data
@Document(indexName = "articlesindex")
@Setting(settingPath = "/settings/settings.json")
@NoArgsConstructor
public class ArticleDocument {
  @Id private String id;

  @Field(type = FieldType.Object)
  private ArticleContent articleContent;

  public ArticleDocument(ArticleContent articleContent) {
    this.articleContent = articleContent;
  }
}
