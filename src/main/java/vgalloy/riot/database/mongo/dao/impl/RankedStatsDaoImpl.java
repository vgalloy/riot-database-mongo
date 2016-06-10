package vgalloy.riot.database.mongo.dao.impl;

import org.mongojack.DBQuery;
import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RankedStatsDaoImpl {

    public static final String REGION_CAN_NOT_BE_NULL = "region can not be null";
    private final GenericDao<RankedStatsEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl the database url
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
        Objects.requireNonNull(region, REGION_CAN_NOT_BE_NULL);
        int max = ((GenericDaoImpl<RankedStatsEntity>) genericDao).getCollection()
                .find(DBQuery.is("region", region))
                .count();
        if (max == 0) {
            return Optional.empty();
        }
        Random random = new SecureRandom();
        int rand = Math.abs(random.nextInt()) % max;
        return Optional.of(((GenericDaoImpl<RankedStatsEntity>) genericDao).getCollection()
                .find(DBQuery.is("region", region))
                .limit(-1)
                .skip(rand)
                .next());
    }
}
