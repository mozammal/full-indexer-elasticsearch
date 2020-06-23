package com.mozammal.fullindexerelasticsearch.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
public class Source {
  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String id;

  @Field(
      type = FieldType.Text,
      analyzer = "autocomplete_index",
      searchAnalyzer = "autocomplete_search")
  private String name;
}
