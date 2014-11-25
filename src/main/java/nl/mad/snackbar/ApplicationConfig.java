package nl.mad.snackbar;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;

/**
 * Class which contains the application configuration for Spring.
 * @author Ruben Zorgman
 */
@Configuration
@ComponentScan(basePackages = "nl.mad.snackbar", excludeFilters = { @Filter(Controller.class) })
public class ApplicationConfig {

    /**
     * Runs the configuration where scheduled is enabled.
     * @author Ruben Zorgman
     */
    @Configuration
    @Profile("scheduled")
    @EnableScheduling
    public static class ProductionScheduledConfig {

    }

}
