package vgalloy.riot.database.api.service;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.api.entity.Entity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 07/07/16.
 */
public interface CommonService<DTO> {

    /**
     * Save the dto.
     *
     * @param region the region
     * @param id     the id of the dto
     * @param dto    the dto
     */
    void save(Region region, Long id, DTO dto);

    /**
     * Get the entity.
     *
     * @param region the region
     * @param itemId the item id
     * @return the datable
     */
    Entity<DTO> get(Region region, Long itemId);

    /**
     * Get one random element in the collection.
     *
     * @param region the region
     * @return the random element
     */
    Entity<DTO> getRandom(Region region);
}
