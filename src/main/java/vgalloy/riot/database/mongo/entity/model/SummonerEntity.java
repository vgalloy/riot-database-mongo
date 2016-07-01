package vgalloy.riot.database.mongo.entity.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import org.mongojack.Id;
import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Identifiable;
import vgalloy.riot.database.mongo.entity.Key;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
@JsonAutoDetect(fieldVisibility = Visibility.NONE, getterVisibility = Visibility.ANY, setterVisibility = Visibility.ANY)
public class SummonerEntity extends Datable<SummonerDto> implements Identifiable {

    private Key key;

    /**
     * Constructor. For Jackson deserialization.
     */
    private SummonerEntity() {
        super(new SummonerDto());
    }

    /**
     * Constructor.
     *
     * @param region      thr region
     * @param summonerDto the summoner dto
     */
    public SummonerEntity(Region region, SummonerDto summonerDto) {
        super(summonerDto);
        key = new Key(region, summonerDto.getId());
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
