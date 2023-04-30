package mk.ukim.finki.emtlab.service;

import mk.ukim.finki.emtlab.model.Books;

import java.util.List;
import java.util.Optional;

public interface BooksService {
    List<Books> findAll();
    Optional<Books> findById(Long id);
    Optional<Books> findByName(String name);
    Optional<Books> save(String name,Long authorId, Integer availableCopies);
    Optional<Books> edit(Long id, String name, Long authorId, Integer availableCopies);
    void deleteById(Long id);
}
