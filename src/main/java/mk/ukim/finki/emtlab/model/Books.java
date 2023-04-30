package mk.ukim.finki.emtlab.model;

import lombok.Data;
import mk.ukim.finki.emtlab.model.enumerations.BooksCategory;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Books {
    @Id
    private long id;
    private String name;
    private BooksCategory category;
    @ManyToOne
    private Author author;
    private int availableCopies;

    public Books() {
    }

    public Books(String name, Author author, int availableCopies) {
        this.name = name;
        this.author = author;
        this.availableCopies = availableCopies;
        this.category = BooksCategory.CLASSICS;
    }


}
