package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.mongo.dao.MatchDetailDao;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.dao.factory.MatchDetailDaoFactory;
import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
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
        return RankedStatsDaoFactory.getDao(databaseUrl, "riot2");
    }

    /**
     * Get the matchDetailDao.
     *
     * @param databaseUrl the database url
     * @return the matchDetailDao
     */
    public MatchDetailDao getMatchDetailDao(String databaseUrl) {
        return MatchDetailDaoFactory.getDao(databaseUrl, "riot2");
    }

    /**
     * Get the queryDao.
     *
     * @param databaseUrl the database url
     * @return the queryDao
     */
    public QueryDao getQueryDao(String databaseUrl) {
        return new QueryDaoImpl(databaseUrl, "riot2");
    }
}
