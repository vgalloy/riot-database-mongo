package vgalloy.riot.database.mongo.dao.impl;

import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;
import vgalloy.riot.database.mongo.dao.RecentGamesDao;
import vgalloy.riot.database.mongo.entity.model.RecentGamesEntity;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 28/05/16.
 */
public class RecentGamesDaoImpl extends AbstractCommonDao<RecentGamesDto, RecentGamesEntity> implements RecentGamesDao {

    public static final String COLLECTION_NAME = "recentGames";

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public RecentGamesDaoImpl(String databaseUrl, String databaseName) {
        super(new GenericDaoImpl<>(databaseUrl, databaseName, COLLECTION_NAME, RecentGamesEntity.class));
    }
}
