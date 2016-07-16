package vgalloy.riot.database.daemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;
import vgalloy.riot.database.api.service.RecentGamesService;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
@Component
public class RecentGamesServiceImpl extends AbstractCommonService<RecentGamesDto> implements RecentGamesService {

    /**
     * Constructor.
     *
     * @param databaseUrl the database url
     */
    public RecentGamesServiceImpl(@Value("${database.url}") String databaseUrl) {
        super(MongoDaoProvider.INSTANCE.getRecentGamesDao(databaseUrl));
    }
}
