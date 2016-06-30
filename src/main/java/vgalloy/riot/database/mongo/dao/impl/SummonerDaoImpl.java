package vgalloy.riot.database.mongo.dao.impl;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import org.mongojack.DBQuery;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.SummonerDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.SummonerEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class SummonerDaoImpl implements SummonerDao {

    public static final String REGION_CAN_NOT_BE_NULL = "region can not be null";
    private final GenericDao<SummonerEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public SummonerDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, "rankedStats", SummonerEntity.class);
    }

    /**
     * Save the dto.
     *
     * @param region      the region
     * @param summonerDto the summoner dto
     */
    public void save(Region region, SummonerDto summonerDto) {
        genericDao.update(new SummonerEntity(region, summonerDto));
    }

    /**
     * Get the rankedStatsEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the ranked stats entity
     */
    public Optional<SummonerEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    /**
     * Get one random.
     *
     * @param region the region
     * @return the rand
     */
    public Optional<SummonerEntity> getRandom(Region region) {
        Objects.requireNonNull(region, REGION_CAN_NOT_BE_NULL);
        int max = ((GenericDaoImpl<SummonerEntity>) genericDao).getCollection()
                .find(DBQuery.is("region", region))
                .count();
        if (max == 0) {
            return Optional.empty();
        }
        Random random = new SecureRandom();
        int rand = Math.abs(random.nextInt()) % max;
        return Optional.of(((GenericDaoImpl<SummonerEntity>) genericDao).getCollection()
                .find(DBQuery.is("region", region))
                .limit(-1)
                .skip(rand)
                .next());
    }
}
