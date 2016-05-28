package vgalloy.riot.database.mongo;

import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.database.api.MatchDao;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public enum MatchDaoImpl implements MatchDao {
    INSTANCE;

    @Override
    public void save(MatchDetail matchDetail) {

    }

    @Override
    public MatchDetail get(long l) {
        return null;
    }
}
