package mk.ukim.finki.emtlab.service.impl;

import mk.ukim.finki.emtlab.model.Country;
import mk.ukim.finki.emtlab.repository.CountryRepository;
import mk.ukim.finki.emtlab.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Override
    public Optional<Country> findById(Long id){
        return countryRepository.findById(id);
    }
    @Override
    public List<Country> findAll(){
        return countryRepository.findAll();
    }
    @Override
    public Optional<Country> save(String name, String continent){
        return Optional.of(countryRepository.save(new Country(name, continent)));
    }
    @Override
    public void deleteById(Long id){
        countryRepository.deleteById(id);
    }
}
