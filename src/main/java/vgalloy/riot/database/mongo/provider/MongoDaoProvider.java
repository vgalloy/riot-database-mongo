package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.mongo.dao.MatchDetailDao;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.dao.SummonerDao;
import vgalloy.riot.database.mongo.dao.factory.DaoFactory;
import vgalloy.riot.database.mongo.dao.impl.MatchDetailDaoImpl;
import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;
import vgalloy.riot.database.mongo.dao.impl.SummonerDaoImpl;
import vgalloy.riot.database.mongo.dao.query.QueryDao;
import vgalloy.riot.database.mongo.dao.query.impl.QueryDaoImpl;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public enum MongoDaoProvider {
    INSTANCE;

    /**
     * Get the rankedStatsDao.
     *
     * @param databaseUrl the database url
     * @return the rankedStatsDao
     */
    public RankedStatsDao getRankedStatsDao(String databaseUrl) {
        return DaoFactory.getDao(RankedStatsDaoImpl.class, databaseUrl, "riot2");
    }

    /**
     * Get the matchDetailDao.
     *
     * @param databaseUrl the database url
     * @return the matchDetailDao
     */
    public MatchDetailDao getMatchDetailDao(String databaseUrl) {
        return DaoFactory.getDao(MatchDetailDaoImpl.class, databaseUrl, "riot2");
    }

    /**
     * Get the SummonerDao.
     *
     * @param databaseUrl the database url
     * @return the SummonerDao
     */
    public SummonerDao getSummonerDao(String databaseUrl) {
        return DaoFactory.getDao(SummonerDaoImpl.class, databaseUrl, "riot2");
    }


    /**
     * Get the queryDao.
     *
     * @param databaseUrl the database url
     * @return the queryDao
     */
    public QueryDao getQueryDao(String databaseUrl) {
        return DaoFactory.getDao(QueryDaoImpl.class, databaseUrl, "riot2");
    }
}
