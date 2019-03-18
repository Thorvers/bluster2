package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Game.findOne", query = "select g from Game g where g.id = :id"),
        @NamedQuery(name = "Game.getAll", query = "select g from Game g")
}
)
public class Game {
    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ManyToOne
    private Developer developer;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany (mappedBy = "games")
    private List<Library> libraries;

    private Date releaseDate;

    @Column(nullable=true)
    private Date rentDate;
    @Column(nullable=true)
    private Date returnDate;
    @Column (name = "rented")
    private boolean out;

    public Game() {

    }

    public Game(String name,Publisher publisher,Developer developer,Date releaseDate) {
        this.name = name;
        this.publisher = publisher;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.out = false;
    }

    public void Rent(Date returnDate) {
        this.rentDate = new Date();
        this.returnDate = returnDate;
        this.out = true;
    }

    public void Return() {
        this.rentDate = null;
        this.returnDate = null;
        this.out = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
