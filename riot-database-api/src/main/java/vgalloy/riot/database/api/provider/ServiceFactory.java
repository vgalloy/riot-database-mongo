package vgalloy.riot.database.api.provider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 18/08/16.
 */
public final class ServiceFactory {

    private static final Map<Class<?>, Object> map = new HashMap<>();

    /**
     * Constructor.
     * To prevent instantiation
     */
    private ServiceFactory() {
        throw new AssertionError();
    }

    /**
     * Get a proxy Service.
     *
     * @param clazz     the class
     * @param queueName the queue Name
     * @param <T>       the type of the class
     * @return the proxy service
     */
    public static <T> T getService(Class<T> clazz, String queueName) {
        T proxyService = (T) map.get(clazz);
        if (proxyService == null) {
            proxyService = createServiceProxy(clazz);
            map.put(clazz, proxyService);
        }
        return proxyService;
    }

    /**
     * Create a proxy service if it doesn't exist.
     *
     * @param clazz the class
     * @param <T>   the type of the class
     * @return the proxy service
     */
    private static <T> T createServiceProxy(Class<T> clazz) {
        return null;
    }
}
