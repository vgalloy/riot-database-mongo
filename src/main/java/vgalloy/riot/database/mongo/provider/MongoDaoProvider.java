package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.mongo.dao.factory.MatchDetailDaoFactory;
import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
import vgalloy.riot.database.mongo.dao.impl.MatchDetailDaoImpl;
import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;
import vgalloy.riot.database.mongo.dao.query.QueryDao;
import vgalloy.riot.database.mongo.dao.query.impl.QueryDaoImpl;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public enum MongoDaoProvider {
    INSTANCE;

    /**
     * Get the rankedStatsDaoImpl.
     *
     * @param databaseUrl the database url
     * @return the rankedStatsDaoImpl
     */
    public RankedStatsDaoImpl getRankedStatsDao(String databaseUrl) {
        return RankedStatsDaoFactory.getDao(databaseUrl, "riot2");
    }

    /**
     * Get the matchDetailDaoImpl.
     *
     * @param databaseUrl the database url
     * @return the matchDetailDaoImpl
     */
    public MatchDetailDaoImpl getMatchDetailDao(String databaseUrl) {
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
