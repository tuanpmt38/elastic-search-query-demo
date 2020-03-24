package vn.nerdcode.spring_elastic_search.configuration;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "vn.nerdcode.spring_elastic_search.repository")
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

  @Value(value = "${elasticsearch.host}")
  private String host;

  @Value(value = "${elasticsearch.port}")
  private Integer port;

  @Value(value = "${elasticsearch.scheme}")
  private String scheme;

  @Override
  public RestHighLevelClient elasticsearchClient() {
    return new RestHighLevelClient(RestClient.builder(new HttpHost(host, port, scheme)));
  }
}
