package vgalloy.riot.database.mongo.dao.commondao.impl;

import vgalloy.riot.api.rest.request.matchlist.dto.MatchReference;
import vgalloy.riot.database.mongo.entity.dataobject.MatchReferenceDo;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class MatchReferenceDaoImpl extends AbstractCommonDao<MatchReference, MatchReferenceDo> {

    public static final String COLLECTION_NAME = "matchReference";

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public MatchReferenceDaoImpl(String databaseUrl, String databaseName) {
        super(new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, MatchReferenceDo.class));
    }
}
