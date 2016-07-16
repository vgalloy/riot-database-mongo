package vgalloy.riot.database.daemon.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import vgalloy.riot.database.daemon.config.ServiceConfig;

import static org.junit.Assert.assertEquals;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 16/07/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class)
public class SummonerServiceImplTest {

    @Test
    public void test() {
        assertEquals(1, 1);
    }
}