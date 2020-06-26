package com.mozammal.fullindexerelasticsearch.model.api.strategy;


public class SimpleRestApiCallFactory {

  public RestApiCallStrategy createRestApiCall(String type, String newsAPIs) {
    RestApiCallStrategy apiStrategy = null;
    if ("newsAPIs".equals(type)) {
      apiStrategy = new RestApiCallStrategyForNewsApis(newsAPIs);
    }
    return apiStrategy;
  }
}
