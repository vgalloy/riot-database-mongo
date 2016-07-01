package vgalloy.riot.database.mongo.dao;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;
import vgalloy.riot.database.mongo.entity.model.RecentGamesEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 01/07/16.
 */
public interface RecentGamesDao {

    /**
     * Save the dto.
     *
     * @param region         the region
     * @param recentGamesDto the recent games dto
     */
    void save(Region region, RecentGamesDto recentGamesDto);

    /**
     * Get the recentGamesEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the recent game entity
     */
    Optional<RecentGamesEntity> get(Region region, long summonerId);

    /**
     * Get one random element in the collection.
     *
     * @param region the region
     * @return the random element
     */
    Optional<RecentGamesEntity> getRandom(Region region);
}
