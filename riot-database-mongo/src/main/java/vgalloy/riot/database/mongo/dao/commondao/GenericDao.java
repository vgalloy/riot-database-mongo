package vgalloy.riot.database.mongo.dao.commondao;

import java.util.Optional;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.entity.dataobject.DataObject;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 02/12/15.
 */
public interface GenericDao<DTO, DATA_OBJECT extends DataObject<DTO>> {

    /**
     * Find the element with the given id. Return null if no element found.
     *
     * @param id The id
     * @return L'object with the given id
     */
    Optional<DATA_OBJECT> getById(String id);

    /**
     * Update an existing element.
     *
     * @param t The element to update
     * @return The modify object
     */
    DATA_OBJECT update(DATA_OBJECT t);

    /**
     * Get one random element in the collection.
     *
     * @param region the region
     * @return the random element
     */
    Optional<DATA_OBJECT> getRandom(Region region);
}
