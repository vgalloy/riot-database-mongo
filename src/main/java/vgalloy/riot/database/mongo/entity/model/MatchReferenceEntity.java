package vgalloy.riot.database.mongo.entity.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import org.mongojack.Id;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.matchlist.dto.MatchReference;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Identifiable;
import vgalloy.riot.database.mongo.entity.Key;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.ANY, setterVisibility = Visibility.ANY)
public class MatchReferenceEntity extends Datable<MatchReference> implements Identifiable, Serializable {

    private static final long serialVersionUID = -1621224271885909447L;

    private Key key;

    /**
     * Constructor. For Jackson deserialization.
     */
    private MatchReferenceEntity() {
        super(new MatchReference());
    }

    /**
     * Constructor.
     *
     * @param region         thr region
     * @param matchReference the match reference
     */
    public MatchReferenceEntity(Region region, MatchReference matchReference) {
        super(matchReference);
        key = new Key(region, matchReference.getMatchId());
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
        return "MatchReference{" +
                "key=" + key +
                ", item=" + item +
                ", lastUpdate" + lastUpdate +
                '}';
    }
}
