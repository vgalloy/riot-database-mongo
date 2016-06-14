package vgalloy.riot.database.mongo.dao.query;

import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 14/06/16.
 */
public interface QueryDao {
    /**
     * Get the winRate of a champion as a map where the key is the number of game played.
     *
     * @param championId the champion id
     * @return the winRate
     */
    Map<Integer, Double> getWinRate(int championId);

    /**
     * Update the result table.
     */
    void updateWinRate();
}