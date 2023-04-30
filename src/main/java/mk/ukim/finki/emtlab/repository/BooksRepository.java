package mk.ukim.finki.emtlab.repository;

import mk.ukim.finki.emtlab.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
    Optional<Books> findByName(String name);

    void deleteByName(String name);
}
