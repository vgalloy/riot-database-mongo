package vgalloy.riot.database.mongo.dao.query.impl;

import org.junit.Test;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 14/06/16.
 */
public class QueryDaoImplTest {

    @Test
    public void test() {
        new QueryDaoImpl("localhost:28001", "riot2").updateWinRate();
        System.out.println(new QueryDaoImpl("localhost:28001", "riot2").getWinRate(7));
    }
}