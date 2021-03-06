package vgalloy.riot.database.mongo.entity;

import java.util.Objects;

import vgalloy.riot.api.rest.constant.Region;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 08/06/16.
 */
public class Key {

    public static final String REGION_CAN_NOT_BE_NULL = "region can not be null";
    public static final String ID_CAN_NOT_BE_NULL = "id can not be null or zero.";

    private final Region region;
    private final Long id;

    /**
     * Constructor.
     *
     * @param region the region
     * @param id     the id
     */
    public Key(Region region, Long id) {
        this.region = Objects.requireNonNull(region, REGION_CAN_NOT_BE_NULL);
        this.id = Objects.requireNonNull(id, ID_CAN_NOT_BE_NULL);
        if (id.equals(0L)) {
            throw new NullPointerException(ID_CAN_NOT_BE_NULL);
        }
    }

    /**
     * Build a key from a string.
     *
     * @param string the string
     * @return the key
     */
    public static Key fromNormalizedString(String string) {
        String[] divided = string.split(" ");
        Region region = Region.valueOf(divided[0]);
        Long id = Long.valueOf(divided[1]);
        return new Key(region, id);
    }

    /**
     * Return a normalized string for the database.
     *
     * @return a normalized string
     */
    public String normalizeString() {
        return region.name() + " " + id;
    }

    public Region getRegion() {
        return region;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Key)) {
            return false;
        }
        Key key = (Key) o;
        return region == key.region &&
                Objects.equals(id, key.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(region, id);
    }

    @Override
    public String toString() {
        return "Key{" +
                "region=" + region +
                ", id=" + id +
                '}';
    }
}
