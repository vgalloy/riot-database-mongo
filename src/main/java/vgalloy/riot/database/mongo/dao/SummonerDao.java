package vgalloy.riot.database.mongo.dao;

import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.mongo.entity.model.SummonerEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 23/06/16.
 */
public interface SummonerDao {

    /**
     * Save the dto.
     *
     * @param region      the region
     * @param summonerDto the summoner dto
     */
    void save(Region region, SummonerDto summonerDto);

    /**
     * Get the rankedStatsEntity.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the ranked stats entity
     */
    Optional<SummonerEntity> get(Region region, long summonerId);

    /**
     * Get one random.
     *
     * @param region the region
     * @return the rand
     */
    Optional<SummonerEntity> getRandom(Region region);
}
