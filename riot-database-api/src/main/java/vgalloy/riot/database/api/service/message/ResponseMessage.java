package vgalloy.riot.database.api.service.message;

import java.util.Objects;

/**
 * @author vgalloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public final class ResponseMessage {

    private final byte[] objectAsByte;

    public ResponseMessage(byte[] objectAsByte) {
        this.objectAsByte = Objects.requireNonNull(objectAsByte);
    }

    public byte[] getObjectAsByte() {
        return objectAsByte;
    }
}
