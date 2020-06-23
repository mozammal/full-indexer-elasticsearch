package com.mozammal.fullindexerelasticsearch.web;

import com.mozammal.fullindexerelasticsearch.model.ArticleDocument;
import com.mozammal.fullindexerelasticsearch.model.repository.DocumentContentRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class Controller {

  @Autowired private DocumentContentRepository documentContentRepository;

  @Operation(
      summary = "full indexer query endpoint",
      description = "This endpoint is used to query the search engine")
  @GetMapping("/search")
  public List<ArticleDocument> search(@RequestParam("q") String query) {
    log.info("query: {}", query);
    return documentContentRepository.search(QueryBuilders.simpleQueryStringQuery(query));
  }

  @Operation(
      summary = "index a document",
      description = "This endpoint is used to index a document")
  @PostMapping("/docs")
  public ArticleDocument save(@RequestBody ArticleDocument articleDocument) {
    documentContentRepository.save(articleDocument);
    return articleDocument;
  }
}
