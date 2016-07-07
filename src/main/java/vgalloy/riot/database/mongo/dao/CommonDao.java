package vgalloy.riot.database.mongo.dao;

import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.entity.Datable;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 07/07/16.
 */
public interface CommonDao<DTO, DATABLE extends Datable<DTO>> {

    /**
     * Save the dto.
     *
     * @param region the region
     * @param dto    the dto
     */
    void save(Region region, DTO dto);

    /**
     * Get the datable.
     *
     * @param region     the region
     * @param summonerId the summoner id
     * @return the datable
     */
    Optional<DATABLE> get(Region region, long summonerId);

    /**
     * Get one random element in the collection.
     *
     * @param region the region
     * @return the random element
     */
    Optional<DATABLE> getRandom(Region region);
}
