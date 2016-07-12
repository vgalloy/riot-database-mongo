package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.api.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.entity.dataobject.RankedStatsDo;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RankedStatsDaoImpl extends AbstractCommonDao<RankedStatsDto, RankedStatsDo> implements RankedStatsDao {

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
