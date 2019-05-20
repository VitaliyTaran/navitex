package com.taran.navitex.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class TestApplicationContext extends ApplicationContext {
    public TestApplicationContext(Environment environment) {
        super(environment);
    }

    @Override
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2);
        embeddedDatabaseBuilder.generateUniqueName(true);
        embeddedDatabaseBuilder.setScriptEncoding("UTF-8");
        embeddedDatabaseBuilder.addScript("classpath:db/migration/V1.1___creation_db.sql");
        embeddedDatabaseBuilder.addScript("classpath:db/test/V1.2__init_test_data.sql");
        return embeddedDatabaseBuilder.build();
    }
}
