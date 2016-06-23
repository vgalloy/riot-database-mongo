package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.MatchDetailDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchDetailDaoImpl implements MatchDetailDao {

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

    @Override
    public void save(Region region, MatchDetail matchDetail) {
        genericDao.update(new MatchDetailEntity(region, matchDetail));
    }

    @Override
    public Optional<MatchDetailEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }
}
