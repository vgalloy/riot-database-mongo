package vgalloy.riot.database.mongo.entity;

import org.mongojack.Id;

import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RankedStatsEntity implements Identifiable {

    private final RankedStatsDto rankedStatsDto;

    /**
     * Constructor.
     *
     * @param rankedStatsDto the ranked stats dto
     */
    public RankedStatsEntity(RankedStatsDto rankedStatsDto) {
        this.rankedStatsDto = rankedStatsDto;
    }

    @Id
    @Override
    public String getId() {
        return String.valueOf(rankedStatsDto.getSummonerId());
    }

    @Override
    public void setId(String id) {
        rankedStatsDto.setSummonerId(Long.valueOf(id));
    }
}
