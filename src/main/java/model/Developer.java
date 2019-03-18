package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Developer {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "developer")
    private List<Game> games;


    public Developer() {

    }

    public Developer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
