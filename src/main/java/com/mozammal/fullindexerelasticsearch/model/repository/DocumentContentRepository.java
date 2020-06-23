package com.mozammal.fullindexerelasticsearch.model.repository;

import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentContentRepository
    extends ElasticsearchRepository<ArticleDocument, String> {
  List<ArticleDocument> search(QueryBuilder query);
}
