package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Optional<Author> save(String name, String surname, Long countryId);
    Author update(String name, String surname, Long countryId);
    void deleteById(Long id);
    List<Author> listAuthors();
    List<Author> searchAuthor(String name);
    Optional<Author> findById(Long id);
}
