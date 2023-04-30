package mk.ukim.finki.emtlab.model;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Author {
    @Id
    private long id;
    private String name;
    private String surname;
    @ManyToOne
    private Country country;

    public Author() {
    }

    public Author(String name, String surname, Country country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }
}
