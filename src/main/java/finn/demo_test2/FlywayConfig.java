package finn.demo_test2;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .dataSource(dataSource)
                .locations("classpath:database/migrations")
                .baselineOnMigrate(true)
                .validateOnMigrate(false)
                .load();

        // Repair the schema history if needed
        flyway.repair();
        flyway.migrate();
        return flyway;
    }
}
