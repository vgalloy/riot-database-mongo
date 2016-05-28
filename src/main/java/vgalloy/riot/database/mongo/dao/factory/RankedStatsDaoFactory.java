package vgalloy.riot.database.mongo.dao.factory;

import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public class RankedStatsDaoFactory {

    private static final Map<String, RankedStatsDaoImpl> RANKED_STATS_DAO_MAP = new HashMap<>();

    /**
     * Return the RankedStatsDao with the correct database.
     *
     * @param dbName the database name
     * @return the rankedStatsDao
     */
    public static RankedStatsDaoImpl getRankedStatsDao(String dbName) {
        RankedStatsDaoImpl rankedStatsDao = RANKED_STATS_DAO_MAP.get(dbName);
        if (rankedStatsDao == null) {
            rankedStatsDao = new RankedStatsDaoImpl(dbName);
            RANKED_STATS_DAO_MAP.put(dbName, rankedStatsDao);
        }
        return rankedStatsDao;
    }
}
