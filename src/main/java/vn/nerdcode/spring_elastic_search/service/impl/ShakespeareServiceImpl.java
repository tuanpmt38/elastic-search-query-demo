package vn.nerdcode.spring_elastic_search.service.impl;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import vn.nerdcode.spring_elastic_search.entity.Shakespeare;
import vn.nerdcode.spring_elastic_search.repository.ShakespeareRepository;
import vn.nerdcode.spring_elastic_search.service.ShakespeareService;

import java.util.List;

@Service
public class ShakespeareServiceImpl implements ShakespeareService {

    @Autowired
    private ShakespeareRepository shakespeareRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Override
    public Page<Shakespeare> findAll(Pageable pageable) {
        return shakespeareRepository.findAll(pageable);
    }

    @Override
    public List<Shakespeare> findByPlayName(String playName) {
        return shakespeareRepository.findAllByPlayNameLike(playName);
    }

    @Override
    public List<Shakespeare> findAllByName(Integer lineId) {

        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        queryBuilder.must(QueryBuilders.termQuery("line_id", lineId));

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();
//        NativeSearchQueryBuilder searchQuery = new NativeSearchQueryBuilder().withQuery(queryBuilder);

        return elasticsearchOperations.queryForList(searchQuery, Shakespeare.class);
    }

    @Override
    public List<Shakespeare> findAllShakespeare() {

        QueryBuilder matchAllQuery = QueryBuilders.matchAllQuery();

        NativeSearchQueryBuilder searchQuery = new NativeSearchQueryBuilder().withQuery(matchAllQuery);

        return elasticsearchOperations.queryForList(searchQuery.build(), Shakespeare.class);
    }

    @Override
    public List<Shakespeare> findAllShakespeareByLineId(Integer lineId_1, Integer lineId_2) {

        QueryBuilder queryBuilder = QueryBuilders
                .rangeQuery("line_id").from(lineId_1).to(lineId_2);

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .build();
        return elasticsearchOperations.queryForList(searchQuery, Shakespeare.class);
    }

    @Override
    public Page<Shakespeare> findAllPage(Integer lineId, Pageable pageable) {

        BoolQueryBuilder queryBuilder = new BoolQueryBuilder();
        queryBuilder.must(QueryBuilders.termQuery("line_id", lineId));

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryBuilder)
                .withPageable(pageable)
                .build();
        return elasticsearchOperations.queryForPage(searchQuery, Shakespeare.class);
    }
}
