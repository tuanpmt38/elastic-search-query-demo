package vn.nerdcode.spring_elastic_search.base;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageResponse<T extends Serializable> {

  private List<T> data;
  private Long totalElements;
  private int totalPages;
  private int pageIndex;
}
