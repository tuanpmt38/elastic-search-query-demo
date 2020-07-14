package vn.nerdcode.spring_elastic_search.base;

import java.io.Serializable;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PageResponse<T extends Serializable> {

  private List<T> data;
  private Long totalElements;
  private int totalPages;
  private int pageIndex;
}
