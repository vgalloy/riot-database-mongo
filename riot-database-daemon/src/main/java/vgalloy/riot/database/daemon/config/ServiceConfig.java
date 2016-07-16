package vgalloy.riot.database.daemon.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import vgalloy.riot.database.api.service.MatchDetailService;
import vgalloy.riot.database.api.service.MatchReferenceService;
import vgalloy.riot.database.api.service.RankedStatsService;
import vgalloy.riot.database.api.service.RecentGamesService;
import vgalloy.riot.database.api.service.SummonerService;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 15/07/16.
 */
@Configuration
@ComponentScan("vgalloy.riot.database.daemon")
public class ServiceConfig {

    @Value("${rmi.server.port}")
    private String rmiServerPort;

    @Autowired
    private MatchDetailService matchDetailService;
    @Autowired
    private MatchReferenceService matchReferenceService;
    @Autowired
    private RankedStatsService rankedStatsService;
    @Autowired
    private RecentGamesService recentGamesService;
    @Autowired
    private SummonerService summonerService;

    /**
     * Get rmi service.
     *
     * @return the rmi Service
     */
    @Bean
    public RmiServiceExporter getMatchDetailService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(MatchDetailService.SERVICE_NAME);
        rmiServiceExporter.setService(matchDetailService);
        rmiServiceExporter.setServiceInterface(MatchDetailService.class);
        rmiServiceExporter.setRegistryPort(Integer.valueOf(rmiServerPort));

        return rmiServiceExporter;
    }

    /**
     * Get rmi service.
     *
     * @return the rmi Service
     */
    @Bean
    public RmiServiceExporter getMatchReferenceService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(MatchReferenceService.SERVICE_NAME);
        rmiServiceExporter.setService(matchReferenceService);
        rmiServiceExporter.setServiceInterface(MatchReferenceService.class);
        rmiServiceExporter.setRegistryPort(Integer.valueOf(rmiServerPort));

        return rmiServiceExporter;
    }

    /**
     * Get rmi service.
     *
     * @return the rmi Service
     */
    @Bean
    public RmiServiceExporter getRankedStatsService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(RankedStatsService.SERVICE_NAME);
        rmiServiceExporter.setService(rankedStatsService);
        rmiServiceExporter.setServiceInterface(RankedStatsService.class);
        rmiServiceExporter.setRegistryPort(Integer.valueOf(rmiServerPort));

        return rmiServiceExporter;
    }

    /**
     * Get rmi service.
     *
     * @return the rmi Service
     */
    @Bean
    public RmiServiceExporter getRecentGamesService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(RecentGamesService.SERVICE_NAME);
        rmiServiceExporter.setService(recentGamesService);
        rmiServiceExporter.setServiceInterface(RecentGamesService.class);
        rmiServiceExporter.setRegistryPort(Integer.valueOf(rmiServerPort));

        return rmiServiceExporter;
    }

    /**
     * Get rmi service.
     *
     * @return the rmi Service
     */
    @Bean
    public RmiServiceExporter getSummonerService() {
        RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
        rmiServiceExporter.setServiceName(SummonerService.SERVICE_NAME);
        rmiServiceExporter.setService(summonerService);
        rmiServiceExporter.setServiceInterface(SummonerService.class);
        rmiServiceExporter.setRegistryPort(Integer.valueOf(rmiServerPort));

        return rmiServiceExporter;
    }
}
