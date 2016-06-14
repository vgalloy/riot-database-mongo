package vgalloy.riot.database.mongo.dao.factory;

import com.mongodb.MongoClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 14/06/16.
 */
public class MongoClientFactory {

    private static final Map<String, MongoClient> MONGO_CLIENT_MAP = new HashMap<>();

    /**
     * Get the mongo client.
     *
     * @param databaseUrl the database url
     * @return the mongo client
     */
    public static MongoClient get(String databaseUrl) {
        Objects.requireNonNull(databaseUrl, "database url can not be null");
        MongoClient mongoClient = MONGO_CLIENT_MAP.get(databaseUrl);
        if (mongoClient == null) {
            mongoClient = new MongoClient(databaseUrl);
            MONGO_CLIENT_MAP.put(databaseUrl, mongoClient);
        }
        return mongoClient;
    }
}
