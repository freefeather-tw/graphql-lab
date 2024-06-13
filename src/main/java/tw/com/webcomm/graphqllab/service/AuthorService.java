package tw.com.webcomm.graphqllab.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.webcomm.graphqllab.entity.Author;
import tw.com.webcomm.graphqllab.repository.AuthorRepository;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepository authorRepository;
  
  public Author getAuthorById(String id) {
    return authorRepository.getReferenceById(id);
  }
}
