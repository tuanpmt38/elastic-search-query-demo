package vn.nerdcode.spring_elastic_search.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import vn.nerdcode.spring_elastic_search.entity.Shakespeare;

public interface ShakespeareRepository extends ElasticsearchRepository<Shakespeare, Long> {

  List<Shakespeare> findAllByPlayNameLike(String playName);
}
