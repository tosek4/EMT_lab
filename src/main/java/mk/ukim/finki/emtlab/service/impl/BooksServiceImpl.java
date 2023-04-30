package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.Books;
import mk.ukim.finki.emtlab.model.enumerations.BooksCategory;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.BooksRepository;
import mk.ukim.finki.emtlab.repository.CountryRepository;
import mk.ukim.finki.emtlab.service.BooksService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public BooksServiceImpl(BooksRepository booksRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.booksRepository = booksRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }
    @Override
    public List<Books> findAll(){
        return booksRepository.findAll();
    }
    @Override
    public Optional<Books> findById(Long id){
        return booksRepository.findById(id);
    }
    @Override
    public Optional<Books> findByName(String name){
        return booksRepository.findByName(name);
    }
    @Override

    public Optional<Books> save(String name,Long authorId, Integer availableCopies){
         Author author = authorRepository.findById(authorId).orElseThrow();
         booksRepository.deleteByName(name);
         return Optional.of(booksRepository.save(new Books(name, author, availableCopies)));
    }
    @Override
    public Optional<Books> edit(Long id, String name, Long authorId, Integer availableCopies){
        Author author = authorRepository.findById(authorId).orElseThrow();
        Books books = booksRepository.findById(id).orElseThrow();

        books.setName(name);
        books.setAvailableCopies(availableCopies);
        books.setAuthor(author);
        return Optional.of(booksRepository.save(books));
    }
    @Override
    public void deleteById(Long id){
        booksRepository.deleteById(id);
    }
}
