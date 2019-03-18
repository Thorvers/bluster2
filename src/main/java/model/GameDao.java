package model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class GameDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Game> getAll() {
        return entityManager.createNamedQuery("Game.getAll", Game.class).getResultList();
    }

    public Game find(Long id) {
        return entityManager.createNamedQuery("Game.findOne", Game.class).setParameter("id", id).getSingleResult();
    }

    public void save(Game game) {
        entityManager.persist(game);
    }

    public void update(Game game) {
        entityManager.merge(game);
    }

    public void delete(Game game) {
        entityManager.remove(game);
    }
}
