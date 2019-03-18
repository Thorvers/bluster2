package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Publisher {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "publisher")
    private List<Game> games;


    public Publisher() {

    }

    public Publisher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
