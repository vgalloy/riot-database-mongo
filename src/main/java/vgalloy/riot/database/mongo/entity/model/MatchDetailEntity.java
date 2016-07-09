package vgalloy.riot.database.mongo.entity.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import org.mongojack.Id;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Identifiable;
import vgalloy.riot.database.mongo.entity.Key;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.ANY, setterVisibility = Visibility.ANY)
public class MatchDetailEntity extends Datable<MatchDetail> implements Identifiable, Serializable {

    private static final long serialVersionUID = -5080357161459486441L;

    private Key key;

    /**
     * Constructor. For Jackson deserialization.
     */
    private MatchDetailEntity() {
        super(new MatchDetail());
    }

    /**
     * Constructor.
     *
     * @param region      thr region
     * @param matchDetail the match detail
     */
    public MatchDetailEntity(Region region, MatchDetail matchDetail) {
        super(matchDetail);
        key = new Key(region, matchDetail.getMatchId());
    }

    @Id
    @Override
    public String getId() {
        return String.valueOf(key.normalizeString());
    }

    @Override
    public void setId(String id) {
        key = Key.fromNormalizedString(id);
    }

    /**
     * Get the region.
     *
     * @return the region in the key
     */
    public Region getRegion() {
        return key.getRegion();
    }

    /**
     * Useless method for jackson serialization.
     *
     * @param region the region
     */
    public void setRegion(Region region) {

    }

    @Override
    public String toString() {
        return "MatchDetailEntity{" +
                "key=" + key +
                ", item=" + item +
                ", lastUpdate" + lastUpdate +
                '}';
    }
}
