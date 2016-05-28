package vgalloy.riot.database.mongo.dao.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.ChampionStatsDto;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.dao.factory.RankedStatsDaoFactory;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 08/06/16.
 */
public class RankedStatsDaoImplTest {

    private final RankedStatsDaoImpl rankedStatsDao = RankedStatsDaoFactory.getRankedStatsDao("riotTest");

    @Test
    public void testNullRegion() {
        try {
            rankedStatsDao.get(null, 1);
            fail("No exception");
        } catch (Exception e) {
            assertSame(NullPointerException.class, e.getClass());
            assertEquals(Key.REGION_CAN_NOT_BE_NULL, e.getMessage());
        }
    }

    @Test
    public void testEmptyDatabase() {
        Optional<RankedStatsEntity> rankedStatsEntity = rankedStatsDao.get(Region.BR, 1);
        assertFalse(rankedStatsEntity.isPresent());
    }

    @Test
    public void testRandomWithNullRegion() {
        try {
            rankedStatsDao.getRandom(null);
            fail("No exception");
        } catch (Exception e) {
            assertSame(NullPointerException.class, e.getClass());
            assertEquals(RankedStatsDaoImpl.REGION_CAN_NOT_BE_NULL, e.getMessage());
        }
    }

    @Test
    public void testEmptyRandom() {
        Optional<RankedStatsEntity> rankedStatsEntity = rankedStatsDao.getRandom(Region.KR);
        assertFalse(rankedStatsEntity.isPresent());
    }

    @Test
    public void testInsertWithNullRankedStatsDto() {
        try {
            rankedStatsDao.save(Region.JP, null);
            fail("No exception");
        } catch (Exception e) {
            assertSame(NullPointerException.class, e.getClass());
            assertEquals(Datable.CAN_NOT_BUILD_A_DATABLE_WITH_A_NULL_ITEM, e.getMessage());
        }
    }

    @Test
    public void testInsertWithIncorrectRankedStatsDto() {
        RankedStatsDto rankedStatsDto = new RankedStatsDto();
        try {
            rankedStatsDao.save(Region.EUW, rankedStatsDto);
            fail("No exception");
        } catch (Exception e) {
            assertSame(NullPointerException.class, e.getClass());
            assertEquals(Key.ID_CAN_NOT_BE_NULL, e.getMessage());
        }
    }

    @Test
    public void testInsertWithCorrectRankedStatsDto() {
        // GIVEN
        RankedStatsDto rankedStatsDto = new RankedStatsDto();
        rankedStatsDto.setSummonerId(10);

        // WHEN
        rankedStatsDao.save(Region.EUW, rankedStatsDto);
        Optional<RankedStatsEntity> result = rankedStatsDao.get(Region.EUW, 10);

        // THEN
        assertTrue(result.isPresent());
        assertEquals(rankedStatsDto, result.get().getItem());
    }

    @Test
    public void testRandomWithCorrectRankedStatsDto() {
        // GIVEN
        RankedStatsDto rankedStatsDto = new RankedStatsDto();
        rankedStatsDto.setSummonerId(11);

        // WHEN
        rankedStatsDao.save(Region.EUW, rankedStatsDto);
        Optional<RankedStatsEntity> result = rankedStatsDao.getRandom(Region.EUW);

        // THEN
        assertTrue(result.isPresent());
    }

    @Test
    public void testCorrectRankedStatsDto() {
        // GIVEN
        RankedStatsDto rankedStatsDto = new RankedStatsDto();
        rankedStatsDto.setChampions(new ArrayList<>());
        rankedStatsDto.getChampions().add(new ChampionStatsDto());
        rankedStatsDto.getChampions().get(0).setId(10);
        rankedStatsDto.getChampions().add(new ChampionStatsDto());
        rankedStatsDto.setSummonerId(12);

        // WHEN
        rankedStatsDao.save(Region.EUW, rankedStatsDto);
        Optional<RankedStatsEntity> result = rankedStatsDao.get(Region.EUW, 12);

        // THEN
        assertTrue(result.isPresent());
        System.out.printf(result.get().toString());
        assertEquals(rankedStatsDto, result.get().getItem());
    }
}