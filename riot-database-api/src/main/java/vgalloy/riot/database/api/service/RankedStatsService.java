package vgalloy.riot.database.api.service;

import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 23/06/16.
 */
public interface RankedStatsService extends CommonService<RankedStatsDto> {

    String SERVICE_NAME = "RankedStatsService";
}
