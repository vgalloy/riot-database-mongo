package vgalloy.riot.database.api.service.util;

import com.rabbitmq.client.ConnectionFactory;

/**
 * @author Created by Vincent Galloy on 18/08/16.
 */
public final class Utils {
    /**
     * Constructor.
     * To prevent instantiation
     */
    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPassword("root");
        connectionFactory.setUsername("root");
        connectionFactory.setPort(29003);
    }

    private Utils() {
        throw new AssertionError();
    }

    public static ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
}
