package vn.nerdcode.spring_elastic_search.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.nerdcode.spring_elastic_search.entity.Shakespeare;

public interface ShakespeareService {

  Page<Shakespeare> findAll(Pageable pageable);

  List<Shakespeare> findByPlayName(String playName);

  List<Shakespeare> findAllByName(Integer lineId);

  List<Shakespeare> findAllShakespeare();

  List<Shakespeare> findAllShakespeareByLineId(Integer lineId_1, Integer lineId_2);

  Page<Shakespeare> findAllPage(Integer lineId, Pageable pageable);
}
