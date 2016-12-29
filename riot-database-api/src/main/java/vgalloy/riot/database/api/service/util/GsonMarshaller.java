package vgalloy.riot.database.api.service.util;

import com.google.gson.Gson;
import vgalloy.javaoverrabbitmq.api.marshaller.RabbitMessageMarshaller;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public final class GsonMarshaller implements RabbitMessageMarshaller {

    public static final RabbitMessageMarshaller INSTANCE = new GsonMarshaller();

    /**
     * Constructor.
     * <p>
     * To prevent external instantiation.
     */
    private GsonMarshaller() {
    }

    @Override
    public <T> byte[] serialize(T message) {
        Gson gson = new Gson();
        String string = gson.toJson(message);
        return string.getBytes();
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        Gson gson = new Gson();
        String messageAsString = new String(bytes);
        return gson.fromJson(messageAsString, clazz);
    }
}
