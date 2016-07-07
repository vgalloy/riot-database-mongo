package vgalloy.riot.database.mongo.dao.impl;

import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;

import vgalloy.riot.api.rest.constant.Region;
import vgalloy.riot.database.mongo.dao.GenericDao;
import vgalloy.riot.database.mongo.dao.factory.MongoClientFactory;
import vgalloy.riot.database.mongo.entity.Identifiable;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/12/15.
 */
public class GenericDaoImpl<T extends Identifiable> implements GenericDao<T> {

    public static final String REGION_CAN_NOT_BE_NULL = "region can not be null";
    private final JacksonDBCollection<T, String> collection;

    /**
     * Constructor with the collectionFactory.
     *
     * @param databaseUrl    the database url
     * @param databaseName   the database name
     * @param collectionName The collection name;
     * @param clazz          the class type
     */
    public GenericDaoImpl(String databaseUrl, String databaseName, String collectionName, Class<T> clazz) {
        MongoClient mongoClient = MongoClientFactory.get(databaseUrl);
        DB mongoDatabase = mongoClient.getDB(databaseName);
        DBCollection dbCollection = mongoDatabase.getCollection(collectionName);
        collection = JacksonDBCollection.wrap(dbCollection, clazz, String.class);
    }

    @Override
    public T getById(String id) {
        return collection.findOneById(id);
    }

    @Override
    public T update(T t) {
        collection.save(t);
        return t;
    }

    @Override
    public Optional<T> getRandom(Region region) {
        Objects.requireNonNull(region, REGION_CAN_NOT_BE_NULL);
        int max = collection
                .find(DBQuery.is("region", region))
                .count();
        if (max == 0) {
            return Optional.empty();
        }
        Random random = new SecureRandom();
        int rand = Math.abs(random.nextInt()) % max;
        return Optional.of(collection
                .find(DBQuery.is("region", region))
                .limit(-1)
                .skip(rand)
                .next());
    }
}
