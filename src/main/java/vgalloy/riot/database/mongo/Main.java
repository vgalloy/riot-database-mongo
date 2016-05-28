package vgalloy.riot.database.mongo;

import vgalloy.riot.api.rest.request.game.dto.GameDto;
import vgalloy.riot.database.api.GameDao;
import vgalloy.riot.database.api.spi.DaoProvider;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * Created by Vincent Galloy on 28/05/16.
 */
public class Main {

    /**
     * Default.
     *
     * @param args de
     */
    public static void main(String[] args) {
        DaoProvider daoProvider = MongoDaoProvider.INSTANCE;
        GameDto gameDto = new GameDto();
        GameDao gameDao = daoProvider.getGameDao();
        gameDao.save(gameDto);
    }
}
