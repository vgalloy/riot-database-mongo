package vgalloy.riot.database.mongo.dao.factory;

import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public final class RankedStatsDaoFactory {

    private static final Map<String, Map<String, RankedStatsDao>> RANKED_STATS_DAO_MAP = new HashMap<>();

    /**
     * Return the RankedStatsDao with the correct database.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     * @return the rankedStatsDao
     */
    public static RankedStatsDao getDao(String databaseUrl, String databaseName) {
        Map<String, RankedStatsDao> databaseUrlMap = RANKED_STATS_DAO_MAP.get(databaseUrl);
        databaseUrlMap = Optional.ofNullable(databaseUrlMap).orElse(new HashMap<>());
        RANKED_STATS_DAO_MAP.put(databaseUrl, databaseUrlMap);
        RankedStatsDao rankedStatsDao = databaseUrlMap.get(databaseName);
        rankedStatsDao = Optional.ofNullable(rankedStatsDao).orElse(new RankedStatsDaoImpl(databaseUrl, databaseName));
        databaseUrlMap.put(databaseName, rankedStatsDao);
        return rankedStatsDao;
    }
}
