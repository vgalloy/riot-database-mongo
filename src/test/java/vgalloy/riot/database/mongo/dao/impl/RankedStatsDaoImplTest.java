package vgalloy.riot.database.mongo.dao.impl;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version.Main;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.api.rest.request.stats.dto.ChampionStatsDto;
import vgalloy.riot.api.rest.request.stats.dto.RankedStatsDto;
import vgalloy.riot.database.mongo.dao.RankedStatsDao;
import vgalloy.riot.database.mongo.dao.factory.DaoFactory;
import vgalloy.riot.database.mongo.entity.Datable;
import vgalloy.riot.database.mongo.entity.Key;
import vgalloy.riot.database.mongo.entity.model.RankedStatsEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

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

    private static final int PORT = 29002;
    private static final String URL = "localhost";

    private static MongodProcess PROCESS;
    private static MongodExecutable EXECUTABLE;

    private final RankedStatsDao rankedStatsDao = DaoFactory.getDao(RankedStatsDaoImpl.class, URL + ":" + PORT, "riotTest");

    @BeforeClass
    public static void setUp() throws IOException {
        MongodStarter starter = MongodStarter.getDefaultInstance();
        EXECUTABLE = starter.prepare(new MongodConfigBuilder()
                .version(Main.PRODUCTION)
                .net(new Net(PORT, Network.localhostIsIPv6()))
                .build());
        PROCESS = EXECUTABLE.start();
    }

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
        Optional<RankedStatsEntity> rankedStatsEntity = rankedStatsDao.get(Region.br, 1);
        assertFalse(rankedStatsEntity.isPresent());
    }

    @Test
    public void testRandomWithNullRegion() {
        try {
            rankedStatsDao.getRandom(null);
            fail("No exception");
        } catch (Exception e) {
            assertSame(NullPointerException.class, e.getClass());
            assertEquals(GenericDaoImpl.REGION_CAN_NOT_BE_NULL, e.getMessage());
        }
    }

    @Test
    public void testEmptyRandom() {
        Optional<RankedStatsEntity> rankedStatsEntity = rankedStatsDao.getRandom(Region.kr);
        assertFalse(rankedStatsEntity.isPresent());
    }

    @Test
    public void testInsertWithNullRankedStatsDto() {
        try {
            rankedStatsDao.save(Region.jp, null);
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
            rankedStatsDao.save(Region.euw, rankedStatsDto);
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
        rankedStatsDao.save(Region.euw, rankedStatsDto);
        Optional<RankedStatsEntity> result = rankedStatsDao.get(Region.euw, 10);

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
        rankedStatsDao.save(Region.euw, rankedStatsDto);
        Optional<RankedStatsEntity> result = rankedStatsDao.getRandom(Region.euw);

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
        rankedStatsDao.save(Region.euw, rankedStatsDto);
        Optional<RankedStatsEntity> result = rankedStatsDao.get(Region.euw, 12);

        // THEN
        assertTrue(result.isPresent());
        System.out.printf(result.get().toString());
        assertEquals(rankedStatsDto, result.get().getItem());
    }

    @AfterClass
    public static void tearDown() {
        PROCESS.stop();
        EXECUTABLE.stop();
    }
}