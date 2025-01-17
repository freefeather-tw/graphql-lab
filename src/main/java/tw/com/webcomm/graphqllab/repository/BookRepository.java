package tw.com.webcomm.graphqllab.repository;

import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.webcomm.graphqllab.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

  @EntityGraph(attributePaths = {"author"})
  Book getReferenceById(String id);

  @EntityGraph(attributePaths = {"author"})
  List<Book> findAll();
}
