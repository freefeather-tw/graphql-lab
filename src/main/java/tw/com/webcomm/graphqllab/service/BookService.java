package tw.com.webcomm.graphqllab.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.webcomm.graphqllab.entity.Book;
import tw.com.webcomm.graphqllab.repository.BookRepository;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;
  
  public Book getBookById(String id) {
    return bookRepository.getReferenceById(id);
  }

  public Book addBook(String name, Integer pageCount, String authorId) {
    Book book = new Book();
    book.setName(name);
    book.setPageCount(pageCount);
    book.setAuthorId(authorId);
    return bookRepository.save(book);
  }

  public List<Book> getAllBooks() {
    return bookRepository.findAll();
  }
}
