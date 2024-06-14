package tw.com.webcomm.graphqllab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {

  @Id
  @GeneratedValue(generator = "system-uuid")
  @GenericGenerator(name = "system-uuid", strategy = "uuid2")
  private String id;

  @Column
  private String name;

  @Column
  private int pageCount;

  @Column(insertable = true, updatable = true)
  private String authorId;

  @ManyToOne(targetEntity = Author.class)
  @JoinColumn(name = "authorId", referencedColumnName = "id", insertable = false, updatable = false)
  private Author author;
  
}
