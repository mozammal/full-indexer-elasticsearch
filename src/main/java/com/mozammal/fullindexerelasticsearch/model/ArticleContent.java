package com.mozammal.fullindexerelasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mozammal.fullindexerelasticsearch.util.JsonDateTimeDeserializer;
import com.mozammal.fullindexerelasticsearch.util.JsonDateTimeSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
public class ArticleContent {
  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String author;

  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String title;

  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String description;

  @Field(type = FieldType.Object)
  private Source source;

  @Field(type = FieldType.Keyword)
  private String url;

  @Field(type = FieldType.Keyword)
  private String urlToImage;

  @JsonSerialize(using = JsonDateTimeSerializer.class)
  @JsonDeserialize(using = JsonDateTimeDeserializer.class)
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
  ZonedDateTime publishedAt;

  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String content;
}
