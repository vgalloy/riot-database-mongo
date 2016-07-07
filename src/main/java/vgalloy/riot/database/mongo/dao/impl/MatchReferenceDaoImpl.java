package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.request.matchlist.dto.MatchReference;
import vgalloy.riot.database.mongo.dao.MatchReferenceDao;
import vgalloy.riot.database.mongo.entity.model.MatchReferenceEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchReferenceDaoImpl extends AbstractCommonDao<MatchReference, MatchReferenceEntity> implements MatchReferenceDao {

    public static final String COLLECTION_NAME = "matchReference";

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public MatchReferenceDaoImpl(String databaseUrl, String databaseName) {
        super(new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, MatchReferenceEntity.class));
    }
}
