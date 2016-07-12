package vgalloy.riot.database.mongo.entity.mapper;

import vgalloy.riot.database.api.entity.Entity;
import vgalloy.riot.database.mongo.entity.dataobject.DataObject;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 12/07/16.
 */
public final class DataObjectMapper {

    /**
     * Constructor.
     */
    private DataObjectMapper() {
    }

    /**
     * Converts a database object into an entity.
     *
     * @param dataObject the database object
     * @param <DTO>      the dto type
     * @return the entity
     */
    public static <DTO> Entity<DTO> map(DataObject<DTO> dataObject) {
        return new Entity<>(dataObject.getRegion(), dataObject.getItemId(), dataObject.getItem(), dataObject.getLastUpdate());
    }
}
