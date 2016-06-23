package vgalloy.riot.database.mongo.dao;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;

import java.util.Optional;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 23/06/16.
 */
public interface MatchDetailDao {

    /**
     * Save the dto.
     *
     * @param region      the region
     * @param matchDetail the match detail
     */
    void save(Region region, MatchDetail matchDetail);

    /**
     * Get the matchDetailEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the match detail entity
     */
    Optional<MatchDetailEntity> get(Region region, long summonerId);
}
