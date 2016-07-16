package vgalloy.riot.database.daemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.api.service.SummonerService;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
@Component
public class SummonerServiceImpl extends AbstractCommonService<SummonerDto> implements SummonerService {

    /**
     * Constructor.
     *
     * @param databaseUrl the database url
     */
    public SummonerServiceImpl(@Value("${database.url}") String databaseUrl) {
        super(MongoDaoProvider.INSTANCE.getSummonerDao(databaseUrl));
    }
}
