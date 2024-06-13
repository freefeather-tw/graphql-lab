package tw.com.webcomm.graphqllab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.com.webcomm.graphqllab.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {

}
