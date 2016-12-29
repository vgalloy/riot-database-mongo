package vgalloy.riot.database.api.provider;

import vgalloy.riot.api.rest.request.game.dto.RecentGamesDto;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.api.rest.request.matchlist.dto.MatchReference;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.api.rest.request.summoner.dto.SummonerDto;
import vgalloy.riot.database.api.service.CommonService;
import vgalloy.riot.database.api.service.MatchDetailService;
import vgalloy.riot.database.api.service.MatchReferenceService;
import vgalloy.riot.database.api.service.QueryService;
import vgalloy.riot.database.api.service.RankedStatsService;
import vgalloy.riot.database.api.service.RecentGamesService;
import vgalloy.riot.database.api.service.SummonerService;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/06/16.
 */
public enum DatabaseQueueServiceProvider {
    INSTANCE;

    /**
     * Get the matchDetailDao.
     *
     * @param databaseUrl the database url
     * @return the matchDetailDao
     */
    public CommonService<MatchDetail> getMatchDetailDao() {
        return ServiceFactory.getService(MatchDetailService.class, MatchDetailService.SERVICE_NAME);
    }

    /**
     * Get the MatchReferenceDao.
     *
     * @param databaseUrl the database url
     * @return the matchReferenceDao
     */
    public CommonService<MatchReference> getMatchReferenceDao() {
        return ServiceFactory.getService(MatchReferenceService.class);
    }

    /**
     * Get the rankedStatsDao.
     *
     * @param databaseUrl the database url
     * @return the rankedStatsDao
     */
    public CommonService<RankedStatsDto> getRankedStatsDao(String databaseUrl) {
        return ServiceFactory.getService(RankedStatsService.class);
    }

    /**
     * Get the RecentGamesDao.
     *
     * @param databaseUrl the database url
     * @return the RecentGamesDao
     */
    public CommonService<RecentGamesDto> getRecentGamesDao() {
        return ServiceFactory.getService(RecentGamesService.class);
    }

    /**
     * Get the SummonerDao.
     *
     * @param databaseUrl the database url
     * @return the SummonerDao
     */
    public CommonService<SummonerDto> getSummonerDao() {
        return ServiceFactory.getService(SummonerService.class);
    }

    /**
     * Get the queryDao.
     *
     * @param databaseUrl the database url
     * @return the queryDao
     */
    public QueryService getQueryDao(String databaseUrl) {
        return ServiceFactory.getService(QueryService.class);
    }
}
