package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.api.GameDao;
import vgalloy.riot.database.api.MatchDao;
import vgalloy.riot.database.api.RankedStatsDao;
import vgalloy.riot.database.api.SummonerDao;
import vgalloy.riot.database.api.spi.DaoProvider;
import vgalloy.riot.database.mongo.GameDaoImp;
import vgalloy.riot.database.mongo.MatchDaoImpl;
import vgalloy.riot.database.mongo.RankedStatsDaoImpl;
import vgalloy.riot.database.mongo.SummonerDaoImpl;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public enum MongoDaoProvider implements DaoProvider {
    INSTANCE;

    @Override
    public GameDao getGameDao() {
        return GameDaoImp.INSTANCE;
    }

    @Override
    public MatchDao getMatchDao() {
        return MatchDaoImpl.INSTANCE;
    }

    @Override
    public SummonerDao getSummonerDao() {
        return SummonerDaoImpl.INSTANCE;
    }

    @Override
    public RankedStatsDao getRankedStatsDao() {
        return RankedStatsDaoImpl.INSTANCE;
    }
}
