package tw.com.webcomm.graphqllab.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

  private String name;
  private Integer pageCount;
  private String authorId;

}
