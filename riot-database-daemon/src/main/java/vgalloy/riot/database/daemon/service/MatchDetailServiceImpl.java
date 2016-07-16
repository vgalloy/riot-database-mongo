package vgalloy.riot.database.daemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.api.service.MatchDetailService;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
@Component
public class MatchDetailServiceImpl extends AbstractCommonService<MatchDetail> implements MatchDetailService {

    /**
     * Constructor.
     *
     * @param databaseUrl the database url
     */
    public MatchDetailServiceImpl(@Value("${database.url}") String databaseUrl) {
        super(MongoDaoProvider.INSTANCE.getMatchDetailDao(databaseUrl));
    }
}
