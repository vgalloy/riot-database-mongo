package vgalloy.riot.database.mongo.dao;

import vgalloy.riot.database.mongo.entity.Identifiable;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 02/12/15.
 */
public interface GenericDao<T extends Identifiable> {

    /**
     * Find the element with the given id. Return null if no element found.
     *
     * @param id The id
     * @return L'object with the given id
     */
    T getById(String id);

    /**
     * Update an existing element.
     *
     * @param t The element to update
     * @return The modify object
     */
    T update(T t);
}
