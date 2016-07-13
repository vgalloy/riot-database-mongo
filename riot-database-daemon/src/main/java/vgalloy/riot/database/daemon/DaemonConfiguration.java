package vgalloy.riot.database.daemon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * @author Vincent Galloy
 *         Created by Vincent Galloy on 13/07/16.
 */
@Configuration
public class DaemonConfiguration {

    /**
     * TODO.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DaemonConfiguration.class);
    }
}
