package vgalloy.riot.database.daemon;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 13/07/16.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {EmbeddedMongoAutoConfiguration.class, MongoAutoConfiguration.class})
public class DaemonStarter {

    /**
     * The entry point of the daemon.
     *
     * @param args the command line arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        new SpringApplicationBuilder()
                .web(false)
                .sources(DaemonStarter.class)
                .run(args);
    }
}
