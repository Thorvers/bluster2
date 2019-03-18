package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Library {

    @Id
    @GeneratedValue
    private long id;
    private String userName;

    @ManyToMany
    private List<Game> games;

    public Library() {

    }

    public Library(String userName,List<Game>games) {
        this.userName = userName;
        this.games = games;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
