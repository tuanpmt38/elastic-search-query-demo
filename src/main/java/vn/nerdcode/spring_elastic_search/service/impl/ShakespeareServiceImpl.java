package vn.nerdcode.spring_elastic_search.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.nerdcode.spring_elastic_search.entity.Shakespeare;
import vn.nerdcode.spring_elastic_search.repository.ShakespeareRepository;
import vn.nerdcode.spring_elastic_search.service.ShakespeareService;

@Service
public class ShakespeareServiceImpl implements ShakespeareService {

  @Autowired
  private ShakespeareRepository shakespeareRepository;

  @Override
  public Page<Shakespeare> findAll(Pageable pageable) {
    return shakespeareRepository.findAll(pageable);
  }

  @Override
  public List<Shakespeare> findByPlayName(String playName) {
    return shakespeareRepository.findAllByPlayNameLike(playName);
  }
}
