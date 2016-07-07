package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.mongo.dao.MatchDetailDao;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchDetailDaoImpl extends AbstractCommonDao<MatchDetail, MatchDetailEntity> implements MatchDetailDao {

    public static final String COLLECTION_NAME = "matchDetail";

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public MatchDetailDaoImpl(String databaseUrl, String databaseName) {
        super(new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, MatchDetailEntity.class));
    }
}
