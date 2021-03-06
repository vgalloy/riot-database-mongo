package vgalloy.riot.database.mongo.dao.commondao.impl;

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
import vgalloy.riot.database.mongo.dao.commondao.GenericDao;
import vgalloy.riot.database.mongo.dao.factory.MongoClientFactory;
import vgalloy.riot.database.mongo.entity.dataobject.DataObject;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/12/15.
 */
public class GenericDaoImpl<DTO, DATA_OBJECT extends DataObject<DTO>> implements GenericDao<DTO, DATA_OBJECT> {

    public static final String REGION_CAN_NOT_BE_NULL = "region can not be null";
    private final JacksonDBCollection<DATA_OBJECT, String> collection;

    /**
     * Constructor with the collectionFactory.
     *
     * @param databaseUrl    the database url
     * @param databaseName   the database name
     * @param collectionName the collection name
     * @param clazz          the data object class
     */
    public GenericDaoImpl(String databaseUrl, String databaseName, String collectionName, Class<DATA_OBJECT> clazz) {
        MongoClient mongoClient = MongoClientFactory.get(databaseUrl);
        DB mongoDatabase = mongoClient.getDB(databaseName);
        DBCollection dbCollection = mongoDatabase.getCollection(collectionName);
        collection = JacksonDBCollection.wrap(dbCollection, clazz, String.class);
    }

    @Override
    public Optional<DATA_OBJECT> getById(String id) {
        return Optional.ofNullable(collection.findOneById(id));
    }

    @Override
    public DATA_OBJECT update(DATA_OBJECT t) {
        collection.save(t);
        return t;
    }

    @Override
    public Optional<DATA_OBJECT> getRandom(Region region) {
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
