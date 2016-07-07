package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.mongo.dao.SummonerDao;
import vgalloy.riot.database.mongo.entity.model.SummonerEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class SummonerDaoImpl extends AbstractCommonDao<SummonerDto, SummonerEntity> implements SummonerDao {

    public static final String COLLECTION_NAME = "summoner";

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public SummonerDaoImpl(String databaseUrl, String databaseName) {
        super(new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, SummonerEntity.class));
    }
}
