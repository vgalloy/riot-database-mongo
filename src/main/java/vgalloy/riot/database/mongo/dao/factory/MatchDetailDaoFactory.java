package vgalloy.riot.database.mongo.dao.factory;

import vgalloy.riot.database.mongo.dao.MatchDetailDao;
import vgalloy.riot.database.mongo.dao.impl.MatchDetailDaoImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public final class MatchDetailDaoFactory {

    private static final Map<String, Map<String, MatchDetailDao>> MATCH_DETAIL_DAO_MAP = new HashMap<>();

    /**
     * Return the MatchDetailDao with the correct database.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     * @return the matchDetailDao
     */
    public static MatchDetailDao getDao(String databaseUrl, String databaseName) {
        Map<String, MatchDetailDao> databaseUrlMap = MATCH_DETAIL_DAO_MAP.get(databaseUrl);
        databaseUrlMap = Optional.ofNullable(databaseUrlMap).orElse(new HashMap<>());
        MATCH_DETAIL_DAO_MAP.put(databaseUrl, databaseUrlMap);
        MatchDetailDao matchDetailDao = databaseUrlMap.get(databaseName);
        matchDetailDao = Optional.ofNullable(matchDetailDao).orElse(new MatchDetailDaoImpl(databaseUrl, databaseName));
        databaseUrlMap.put(databaseName, matchDetailDao);
        return matchDetailDao;
    }
}
