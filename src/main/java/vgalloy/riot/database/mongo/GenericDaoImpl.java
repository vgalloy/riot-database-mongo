package vgalloy.riot.database.mongo;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import org.mongojack.JacksonDBCollection;
import org.mongojack.WriteResult;

import vgalloy.riot.database.mongo.entity.Identifiable;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 09/12/15.
 */
public class GenericDaoImpl<T extends Identifiable> implements GenericDao<T> {

    private final JacksonDBCollection<T, String> collection;

    /**
     * Constructor with the collectionFactory.
     *
     * @param collectionName The collection name;
     * @param clazz          the class type
     */
    public GenericDaoImpl(String collectionName, Class<T> clazz) {
        MongoClient mongoClient = new MongoClient("localhost"); // TODO mettre des properties ?
        DB mongoDatabase = mongoClient.getDB("riot"); // TODO mettre des properties ?
        DBCollection dbCollection = mongoDatabase.getCollection(collectionName);
        //        ((ParameterizedType)getClass().getGenericInfo()).getTypeParameters()[0]
        //        Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.collection = JacksonDBCollection.wrap(dbCollection, clazz, String.class);
    }

    @Override
    public List<T> getAll() {
        return collection.find().toArray();
    }

    @Override
    public T create(T t) {
        WriteResult<T, String> writeResult = collection.insert(t);
        t.setId(writeResult.getSavedId());
        return t;
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
    public void deleteById(String id) {
        collection.removeById(id);
    }

    @Override
    public void removeAll() {
        collection.getDbCollection().remove(new BasicDBObject());
    }
}
