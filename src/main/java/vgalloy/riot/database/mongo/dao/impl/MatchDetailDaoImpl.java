package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchDetailDaoImpl {

    private final GenericDao<MatchDetailEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public MatchDetailDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, "matchDetail", MatchDetailEntity.class);
    }

    /**
     * Save the dto.
     *
     * @param region      the region
     * @param matchDetail the match detail
     */
    public void save(Region region, MatchDetail matchDetail) {
        genericDao.update(new MatchDetailEntity(region, matchDetail));
    }

    /**
     * Get the matchDetailEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the match detail entity
     */
    public Optional<MatchDetailEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }
}
