package vgalloy.riot.database.mongo.dao.impl;

import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RankedStatsDaoImpl implements RankedStatsDao {

    public static final String COLLECTION_NAME = "rankedStats";

    private final GenericDao<RankedStatsEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public RankedStatsDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, RankedStatsEntity.class);
    }

    @Override
    public void save(Region region, RankedStatsDto rankedStatsDto) {
        genericDao.update(new RankedStatsEntity(region, rankedStatsDto));
    }

    @Override
    public Optional<RankedStatsEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    @Override
    public Optional<RankedStatsEntity> getRandom(Region region) {
        return genericDao.getRandom(region);
    }
}
