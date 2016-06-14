package vgalloy.riot.database.mongo.dao.factory;

import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public final class RankedStatsDaoFactory {

    private static final Map<String, Map<String, RankedStatsDaoImpl>> RANKED_STATS_DAO_MAP = new HashMap<>();

    /**
     * Return the RankedStatsDaoImpl with the correct database.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     * @return the rankedStatsDao
     */
    public static RankedStatsDaoImpl getDao(String databaseUrl, String databaseName) {
        Map<String, RankedStatsDaoImpl> databaseUrlMap = RANKED_STATS_DAO_MAP.get(databaseUrl);
        if (databaseUrlMap == null) {
            databaseUrlMap = new HashMap<>();
            RANKED_STATS_DAO_MAP.put(databaseUrl, databaseUrlMap);
        }
        RankedStatsDaoImpl rankedStatsDao = databaseUrlMap.get(databaseName);
        if (rankedStatsDao == null) {
            rankedStatsDao = new RankedStatsDaoImpl(databaseUrl, databaseName);
            databaseUrlMap.put(databaseName, rankedStatsDao);
        }
        return rankedStatsDao;
    }
}
