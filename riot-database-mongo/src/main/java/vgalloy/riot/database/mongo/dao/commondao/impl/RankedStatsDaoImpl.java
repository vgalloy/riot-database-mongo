package vgalloy.riot.database.mongo.dao.commondao.impl;

import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.entity.dataobject.RankedStatsDo;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RankedStatsDaoImpl extends AbstractCommonDao<RankedStatsDto, RankedStatsDo> {

    public static final String COLLECTION_NAME = "rankedStats";

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public RankedStatsDaoImpl(String databaseUrl, String databaseName) {
        super(new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, RankedStatsDo.class));
    }
}
