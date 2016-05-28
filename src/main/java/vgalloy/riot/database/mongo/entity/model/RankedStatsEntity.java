package vgalloy.riot.database.mongo.entity.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.mongojack.Id;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Identifiable;
import vgalloy.riot.database.mongo.entity.Key;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.ANY, setterVisibility = JsonAutoDetect.Visibility.ANY)
public class RankedStatsEntity extends Datable<RankedStatsDto> implements Identifiable {

    private Key key;

    /**
     * Constructor.
     */
    private RankedStatsEntity() {
        super(new RankedStatsDto());
    }

    /**
     * Constructor.
     *
     * @param region         thr region
     * @param rankedStatsDto the ranked stats dto
     */
    public RankedStatsEntity(Region region, RankedStatsDto rankedStatsDto) {
        super(rankedStatsDto);
        key = new Key(region, rankedStatsDto.getSummonerId());
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
        return "RankedStatsEntity{" +
                "key=" + key +
                ", item=" + item +
                ", lastUpdate" + lastUpdate +
                '}';
    }
}
