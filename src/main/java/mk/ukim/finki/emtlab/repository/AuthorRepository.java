package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
    List<Author> findAllByNameLike(String text);
    void deleteByName(String name);
}
