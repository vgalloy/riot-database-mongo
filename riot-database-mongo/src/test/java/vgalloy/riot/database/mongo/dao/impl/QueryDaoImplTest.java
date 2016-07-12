package vgalloy.riot.database.mongo.dao.impl;

import org.junit.Ignore;
import org.junit.Test;
import vgalloy.riot.database.mongo.dao.query.QueryDao;
import vgalloy.riot.database.mongo.provider.MongoDaoProvider;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 07/07/16.
 */
public class QueryDaoImplTest {

    @Test
    @Ignore
    public void testWinRate() {
        QueryDao queryDao = MongoDaoProvider.INSTANCE.getQueryDao("localhost:28001");
        //queryDao.updateWinRate();
        System.out.println(queryDao.getWinRate(7));
    }

    @Test
    @Ignore
    public void testPosition() {
        QueryDao queryDao = MongoDaoProvider.INSTANCE.getQueryDao("localhost:28001");
        //queryDao.updatePosition();
        System.out.println(queryDao.getPosition(24550736, 7));
    }
}
