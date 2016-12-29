package vgalloy.riot.database.api.service.message;

import vgalloy.riot.api.rest.constant.Region;

import java.util.Objects;

/**
 * @author vgalloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public final class SaveParameterMessage {

    private final Region region;
    private final Long id;
    private final byte[] objectAsByte;

    public SaveParameterMessage(Region region, Long id, byte[] objectAsByte) {
        this.region = Objects.requireNonNull(region);
        this.id = Objects.requireNonNull(id);
        this.objectAsByte = Objects.requireNonNull(objectAsByte);
    }

    public Region getRegion() {
        return region;
    }

    public Long getId() {
        return id;
    }

    public byte[] getObjectAsByte() {
        return objectAsByte;
    }
}
