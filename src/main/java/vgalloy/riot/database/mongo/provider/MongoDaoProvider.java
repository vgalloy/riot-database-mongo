package vgalloy.riot.database.mongo.provider;

import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
import vgalloy.riot.database.mongo.dao.impl.RankedStatsDaoImpl;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public enum MongoDaoProvider {
    INSTANCE;

    public RankedStatsDaoImpl getRankedStatsDao() {
        return RankedStatsDaoFactory.getRankedStatsDao("riot2");
    }
}
