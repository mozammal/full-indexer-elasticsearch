package com.mozammal.fullindexerelasticsearch.model.api.strategy;

import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface RestApiCallStrategy {

  public List<ArticleDocument> call() throws UnsupportedEncodingException;
}
