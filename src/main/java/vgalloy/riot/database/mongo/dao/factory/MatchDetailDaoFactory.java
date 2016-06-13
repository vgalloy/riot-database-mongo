package vgalloy.riot.database.mongo.dao.factory;

import vgalloy.riot.database.mongo.dao.impl.MatchDetailDaoImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public class MatchDetailDaoFactory {

    private static final Map<String, MatchDetailDaoImpl> MATCH_DETAIL_DAO_MAP = new HashMap<>();

    /**
     * Return the MatchDetailDaoImpl with the correct database.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     * @return the matchDetailDao
     */
    public static MatchDetailDaoImpl getMatchDetailDao(String databaseUrl, String databaseName) {
        MatchDetailDaoImpl matchDetailDao = MATCH_DETAIL_DAO_MAP.get(databaseName);
        if (matchDetailDao == null) {
            matchDetailDao = new MatchDetailDaoImpl(databaseUrl, databaseName);
            MATCH_DETAIL_DAO_MAP.put(databaseName, matchDetailDao);
        }
        return matchDetailDao;
    }
}
