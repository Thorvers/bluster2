package resource;

import model.Game;
import model.GameDao;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.util.List;

@Path("game")
public class GameResource {
    //@Inject
    @EJB
    private GameDao gameDao;

    @GET
    @Produces("application/json")
    public List<Game> all() {
        return gameDao.getAll();
    }

    @POST
    @Produces("application/json")
    public void save(Game game) {
        gameDao.save(game);
    }

    @PUT
    @Consumes("application/json")
    public void update(Game game) {
        gameDao.update(game);
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public void delete(@PathParam("id") Long id) {
        Game game = gameDao.find(id);
        gameDao.delete(game);
    }
}
