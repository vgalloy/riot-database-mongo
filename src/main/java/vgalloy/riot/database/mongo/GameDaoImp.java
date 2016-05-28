package vgalloy.riot.database.mongo;

import vgalloy.riot.api.rest.request.game.dto.GameDto;
import vgalloy.riot.database.api.GameDao;
import vgalloy.riot.database.mongo.entity.GameEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public enum GameDaoImp implements GameDao {
    INSTANCE;

    private GenericDao<GameEntity> genericDao;

    /**
     * Constructor.
     */
    GameDaoImp() {
        genericDao = new GenericDaoImpl<>("game", GameEntity.class);
    }

    @Override
    public void save(GameDto gameDto) {
        genericDao.update(new GameEntity(gameDto));
    }

    @Override
    public GameDto get(long l) {
        return null;
    }
}
