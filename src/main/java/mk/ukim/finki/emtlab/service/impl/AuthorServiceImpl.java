package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Author;
import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.repository.AuthorRepository;
import mk.ukim.finki.emtlab.repository.CountryRepository;
import mk.ukim.finki.emtlab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }
    @Override
    public Optional<Author> save(String name, String surname, Long countryId){
        Country country = this.countryRepository.findById(countryId).orElseThrow();

        authorRepository.deleteByName(name);
        return Optional.of(authorRepository.save(new Author(name, surname, country)));

    }
    @Override
    public Author update(String name, String surname, Long countryId){
        Country country = this.countryRepository.findById(countryId).orElseThrow();

        Author author = new Author(name, surname, country);
        authorRepository.save(author);
        return author;
    }
    @Override
    public void deleteById(Long id){
        authorRepository.deleteById(id);
    }
    @Override
    public List<Author> listAuthors(){
        return authorRepository.findAll();
    }
    @Override
    public List<Author> searchAuthor(String name){
        return authorRepository.findAllByNameLike(name);
    }
    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

}
