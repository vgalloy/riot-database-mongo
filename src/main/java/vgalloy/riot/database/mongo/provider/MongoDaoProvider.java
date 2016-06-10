package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
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
        return RankedStatsDaoFactory.getRankedStatsDao(databaseUrl, "riot2");
    }
}
