package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.mongo.dao.factory.MatchDetailDaoFactory;
import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
import vgalloy.riot.database.mongo.dao.impl.MatchDetailDaoImpl;
import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;

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
}
