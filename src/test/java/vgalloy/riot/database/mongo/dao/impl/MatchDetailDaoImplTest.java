package vgalloy.riot.database.mongo.dao.impl;

import org.junit.Test;
import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.mach.dto.MatchDetail;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.dao.factory.MatchDetailDaoFactory;
import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.MatchDetailEntity;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by Vincent Galloy on 14/06/16.
 */
public class MatchDetailDaoImplTest {

    private final MatchDetailDaoImpl matchDetailDao = MatchDetailDaoFactory.getDao("localhost", "riotTest");

    @Test
    public void testInsertWithCorrectMatchDetailDto() {
        // GIVEN
        MatchDetail matchDetail = new MatchDetail();
        matchDetail.setMatchId(10);

        // WHEN
        matchDetailDao.save(Region.EUW, matchDetail);
        Optional<MatchDetailEntity> result = matchDetailDao.get(Region.EUW, 10);

        // THEN
        assertTrue(result.isPresent());
        assertEquals(matchDetail, result.get().getItem());
    }

}