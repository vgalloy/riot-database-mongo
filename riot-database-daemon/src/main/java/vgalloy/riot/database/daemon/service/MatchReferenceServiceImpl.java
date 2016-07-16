package vgalloy.riot.database.daemon.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import vgalloy.riot.api.rest.request.matchlist.dto.MatchReference;
import vgalloy.riot.database.api.service.MatchReferenceService;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
@Component
public class MatchReferenceServiceImpl extends AbstractCommonService<MatchReference> implements MatchReferenceService {

    /**
     * Constructor.
     *
     * @param databaseUrl the database url
     */
    public MatchReferenceServiceImpl(@Value("${database.url}") String databaseUrl) {
        super(MongoDaoProvider.INSTANCE.getMatchReferenceDao(databaseUrl));
    }
}
