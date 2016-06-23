package vgalloy.riot.database.mongo.dao;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 23/06/16.
 */
public interface RankedStatsDao {

    /**
     * Save the dto.
     *
     * @param region         the region
     * @param rankedStatsDto the ranked stats dto
     */
    void save(Region region, RankedStatsDto rankedStatsDto);

    /**
     * Get the rankedStatsEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the ranked stats entity
     */
    Optional<RankedStatsEntity> get(Region region, long summonerId);

    /**
     * Get one random.
     *
     * @param region the region
     * @return the rand
     */
    Optional<RankedStatsEntity> getRandom(Region region);
}
