package vgalloy.riot.database.mongo.dao.factory;

import vgalloy.riot.database.mongo.dao.impl.MatchDetailDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public final class MatchDetailDaoFactory {

    private static final Map<String, Map<String, MatchDetailDaoImpl>> MATCH_DETAIL_DAO_MAP = new HashMap<>();

    /**
     * Return the MatchDetailDaoImpl with the correct database.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     * @return the matchDetailDao
     */
    public static MatchDetailDaoImpl getDao(String databaseUrl, String databaseName) {
        Map<String, MatchDetailDaoImpl> databaseUrlMap = MATCH_DETAIL_DAO_MAP.get(databaseUrl);
        if (databaseUrlMap == null) {
            databaseUrlMap = new HashMap<>();
            MATCH_DETAIL_DAO_MAP.put(databaseUrl, databaseUrlMap);
        }
        MatchDetailDaoImpl matchDetailDao = databaseUrlMap.get(databaseName);
        if (matchDetailDao == null) {
            matchDetailDao = new MatchDetailDaoImpl(databaseUrl, databaseName);
            databaseUrlMap.put(databaseName, matchDetailDao);
        }
        return matchDetailDao;
    }
}
