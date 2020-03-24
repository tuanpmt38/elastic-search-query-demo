package vn.nerdcode.spring_elastic_search.entity;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.io.Serializable;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "shakespeare", type = "_doc")
public class Shakespeare implements Serializable {

  @Id
  private String id;
  private String speaker;
  @JsonAlias("play_name")
  private String playName;
  @JsonAlias("line_id")
  private Integer lineId;
  @JsonAlias("speech_number")
  private Integer speechNumber;
  @JsonAlias("text_entry")
  private String textEntry;
}
