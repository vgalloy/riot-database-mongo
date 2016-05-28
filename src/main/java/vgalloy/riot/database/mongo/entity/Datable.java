package vgalloy.riot.database.mongo.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 08/06/16.
 */
public abstract class Datable<T> {

    public static final String CAN_NOT_BUILD_A_DATABLE_WITH_A_NULL_ITEM = "Can not build a Datable with a null item";
    protected final T item;
    protected final long lastUpdate;

    /**
     * Constructor.
     *
     * @param item the item
     */
    public Datable(T item) {
        this.item = Objects.requireNonNull(item, CAN_NOT_BUILD_A_DATABLE_WITH_A_NULL_ITEM);
        lastUpdate = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
    }

    public T getItem() {
        return item;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }
}
