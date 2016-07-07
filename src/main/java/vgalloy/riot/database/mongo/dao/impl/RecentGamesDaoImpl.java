package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.RecentGamesDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.RecentGamesEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RecentGamesDaoImpl implements RecentGamesDao {

    public static final String COLLECTION_NAME = "recentGames";

    private final GenericDao<RecentGamesEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public RecentGamesDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, RecentGamesEntity.class);
    }

    @Override
    public void save(Region region, RecentGamesDto recentGamesDto) {
        genericDao.update(new RecentGamesEntity(region, recentGamesDto));
    }

    @Override
    public Optional<RecentGamesEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    @Override
    public Optional<RecentGamesEntity> getRandom(Region region) {
        return genericDao.getRandom(region);
    }
}
