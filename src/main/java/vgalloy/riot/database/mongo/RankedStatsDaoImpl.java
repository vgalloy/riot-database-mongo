package vgalloy.riot.database.mongo;

import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.api.RankedStatsDao;
import vgalloy.riot.database.mongo.entity.RankedStatsEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public enum RankedStatsDaoImpl implements RankedStatsDao {
    INSTANCE;

    private GenericDao<RankedStatsEntity> genericDao;

    /**
     * Constructor.
     */
    RankedStatsDaoImpl() {
        genericDao = new GenericDaoImpl<>("rankedStats", RankedStatsEntity.class);
    }

    @Override
    public void save(RankedStatsDto rankedStatsDto) {
        genericDao.update(new RankedStatsEntity(rankedStatsDto));
    }
}
