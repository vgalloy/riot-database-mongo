package vgalloy.riot.database.daemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.api.service.RankedStatsService;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
@Component
public class RankedStatsServiceImpl extends AbstractCommonService<RankedStatsDto> implements RankedStatsService {

    /**
     * Constructor.
     *
     * @param databaseUrl the database url
     */
    public RankedStatsServiceImpl(@Value("${database.url}") String databaseUrl) {
        super(MongoDaoProvider.INSTANCE.getRankedStatsDao(databaseUrl));
    }
}
