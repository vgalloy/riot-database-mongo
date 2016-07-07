package vgalloy.riot.database.mongo.dao.impl;

import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.matchlist.dto.MatchReference;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.MatchReferenceDao;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.MatchReferenceEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchReferenceDaoImpl implements MatchReferenceDao {

    public static final String COLLECTION_NAME = "matchReference";

    private final GenericDao<MatchReferenceEntity> genericDao;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public MatchReferenceDaoImpl(String databaseUrl, String databaseName) {
        genericDao = new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, MatchReferenceEntity.class);
    }

    @Override
    public void save(Region region, MatchReference matchReference) {
        genericDao.update(new MatchReferenceEntity(region, matchReference));
    }

    @Override
    public Optional<MatchReferenceEntity> get(Region region, long summonerId) {
        Key key = new Key(region, summonerId);
        return Optional.ofNullable(genericDao.getById(key.normalizeString()));
    }

    @Override
    public Optional<MatchReferenceEntity> getRandom(Region region) {
        return genericDao.getRandom(region);
    }
}
