package tw.com.webcomm.graphqllab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.EntityGraph;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
  @Id
  private String id;

  @Column
  private String firstName;

  @Column
  private String lastName;

}
