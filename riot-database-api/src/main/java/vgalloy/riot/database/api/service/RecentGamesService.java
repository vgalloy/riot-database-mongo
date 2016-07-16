package vgalloy.riot.database.api.service;

import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 01/07/16.
 */
public interface RecentGamesService extends CommonService<RecentGamesDto> {

    String SERVICE_NAME = "RecentGamesService";
}
