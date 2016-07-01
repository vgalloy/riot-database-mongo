package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.SummonerDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.SummonerEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class SummonerDaoImpl implements SummonerDao {

    private final GenericDao<SummonerEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public SummonerDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, "summoner", SummonerEntity.class);
    }

    @Override
    public void save(Region region, SummonerDto summonerDto) {
        genericDao.update(new SummonerEntity(region, summonerDto));
    }

    @Override
    public Optional<SummonerEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    @Override
    public Optional<SummonerEntity> getRandom(Region region) {
        return genericDao.getRandom(region);
    }
}
