package vgalloy.riot.database.mongo.dao.query.impl;

import java.util.HashMap;
import java.util.Map;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import vgalloy.riot.database.mongo.dao.factory.MongoClientFactory;
import vgalloy.riot.database.mongo.dao.query.QueryDao;

import static java.util.Arrays.asList;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 14/06/16.
 */
public class QueryDaoImpl implements QueryDao {

    private final MongoDatabase mongoDatabase;

    /**
     * Constructor.
     *
     * @param databaseUrl  the database url
     * @param databaseName the database name
     */
    public QueryDaoImpl(String databaseUrl, String databaseName) {
        MongoClient mongoClient = MongoClientFactory.get(databaseUrl);
        mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    @Override
    public Map<Integer, Double> getWinRate(int championId) {
        Map<Integer, Double> map = new HashMap<>();
        FindIterable<Document> result = mongoDatabase.getCollection("result").find(new Document("_id.championId", championId));
        int index = 0;
        for (Document o : result) {
            map.put(index, Math.floor(1000 * o.getDouble("result")) / 10);
            index++;
        }
        return map;
    }

    @Override
    public void updateWinRate() {
        mongoDatabase.getCollection("rankedStats").aggregate(asList(
                new BasicDBObject("$unwind", "$item.champions"),
                new BasicDBObject("$group",
                        new Document("_id", new Document("championId", "$item.champions.id").append("played", "$item.champions.stats.totalSessionsPlayed"))
                                .append("played", new Document("$sum", "$item.champions.stats.totalSessionsPlayed"))
                                .append("won", new Document("$sum", "$item.champions.stats.totalSessionsWon"))
                                .append("total", new Document("$sum", 1))
                ),
                new BasicDBObject("$project", new Document("result", new Document("$divide", new String[]{"$won", "$played"})).append("total", 1)),
                new BasicDBObject("$sort", new Document("_id", 1)),
                new BasicDBObject("$out", "result")
        )).iterator();
    }
}
