package tw.com.webcomm.graphqllab.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RestController;
import tw.com.webcomm.graphqllab.entity.Author;
import tw.com.webcomm.graphqllab.entity.Book;
import tw.com.webcomm.graphqllab.service.AuthorService;
import tw.com.webcomm.graphqllab.service.BookService;

@RestController
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
    return bookService.getBookById(id);
  }

  @MutationMapping("addBook")
  public Book addBook(
      @Argument String name,
      @Argument Integer pageCount,
      @Argument String authorId) {
    return bookService.addBook(name, pageCount, authorId);
  }

  @SchemaMapping
  public Author author(Book book) {
    return authorService.getAuthorById(book.getAuthorId());
  }
}
