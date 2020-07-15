# Getting started

## 1. Install elasticsearch
 You can get latest version of Elasticsearch [here](https://www.elastic.co/downloads/elasticsearch).

 Follow the document to install Elasticsearch then you can run it on your own hardware.
 
## 2.Prepare data:
 I'm using Elasticsearch `6.8.4` then I get the sample data from [here](https://www.elastic.co/guide/en/kibana/6.8/tutorial-load-dataset.html).
 Follow the tutorial from reference document, I added document from `shakespeare.json` to my local Elasticsearch.
 
## 3.Setup project:
 In this example, we use:
 - `SpringBoot 2.2.5 RELEASE`
 - `Spring Data Elasticsearch starter pack`
 - `Elasticsearch 6.8.4`
 - `Elasticsearch Client 6.8.4`
 - `Java 8`
 
 You can find the most compatible version [here](https://docs.spring.io/spring-data/elasticsearch/docs/current/reference/html/#preface.versions)
 ## 4.Query elastic-search
  Sử dụng BoolQuertBuilder
  
  BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
  queryBuilder.must(QueryBuilders.termQuery("line_id", lineId));
  SearchQuery searchQuery = new NativeSearchQueryBuilder()
          .withQuery(queryBuilder)
          .build();
  return elasticsearchOperations.queryForList(searchQuery, Shakespeare.class);
  
 You can find the query elastic-search [here](https://www.baeldung.com/elasticsearch-java)
 
 You can find the query-dsl [here](https://viblo.asia/p/query-dsl-trong-elasticsearch-Eb85oJq2l2G)
