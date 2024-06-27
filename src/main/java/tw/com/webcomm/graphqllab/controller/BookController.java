package tw.com.webcomm.graphqllab.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;
import tw.com.webcomm.graphqllab.entity.Author;
import tw.com.webcomm.graphqllab.entity.Book;
import tw.com.webcomm.graphqllab.service.AuthorService;
import tw.com.webcomm.graphqllab.service.BookService;

@RestController
@Slf4j
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private AuthorService authorService;

  @QueryMapping("getAllBooks")
  public List<Book> getAllBooks() {
    return bookService.getAllBooks();
  }
  
  @QueryMapping("getBookById")
  public Book bookById(@Argument String id) {
    Book result = bookService.getBookById(id);
    if (null != result) {
      log.debug("get author: {}", result.getAuthor().getId());
    }
    return result;
  }

  @MutationMapping("addBook")
  public Book addBook(
      @Argument String name,
      @Argument Integer pageCount,
      @Argument String authorId) {
    return bookService.addBook(name, pageCount, authorId);
  }

  @BatchMapping(field = "author", typeName = "Book")
  public Map<Book, Author> author(List<Book> books) {
    log.debug("get author by books");
    return books.stream()
        .collect(Collectors.toMap(
            book -> book,
            book -> book.getAuthor()));
  }
}
