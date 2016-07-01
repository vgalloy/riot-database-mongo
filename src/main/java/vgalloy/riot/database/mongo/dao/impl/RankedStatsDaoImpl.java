package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RankedStatsDaoImpl implements RankedStatsDao {

    private final GenericDao<RankedStatsEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public RankedStatsDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, "rankedStats", RankedStatsEntity.class);
    }

    /**
     * Save the dto.
     *
     * @param region         the region
     * @param rankedStatsDto the ranked stats dto
     */
    public void save(Region region, RankedStatsDto rankedStatsDto) {
        genericDao.update(new RankedStatsEntity(region, rankedStatsDto));
    }

    /**
     * Get the rankedStatsEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the ranked stats entity
     */
    public Optional<RankedStatsEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    /**
     * Get one random.
     *
     * @param region the region
     * @return the rand
     */
    public Optional<RankedStatsEntity> getRandom(Region region) {
        return genericDao.getRandom(region);
    }
}
