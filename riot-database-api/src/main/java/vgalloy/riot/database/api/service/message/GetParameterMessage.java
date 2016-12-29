package vgalloy.riot.database.api.service.message;

import vgalloy.riot.api.rest.constant.Region;

import java.util.Objects;

/**
 * @author vgalloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public final class GetParameterMessage {

    private final Region region;
    private final Long id;

    public GetParameterMessage(Region region, Long id) {
        this.region = Objects.requireNonNull(region);
        this.id = Objects.requireNonNull(id);
    }

    public Region getRegion() {
        return region;
    }

    public Long getId() {
        return id;
    }

}
