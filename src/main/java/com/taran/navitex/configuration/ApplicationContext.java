package com.taran.navitex.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = {"com.taran.navitex.repository", "com.taran.navitex.service" })
public class ApplicationContext {
    private Environment environment;

    public ApplicationContext() {
    }

    @Autowired
    public ApplicationContext(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        config.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
        config.setUsername(environment.getRequiredProperty("jdbc.username"));
        config.setPassword(environment.getRequiredProperty("jdbc.password"));
        config.setMaximumPoolSize(20);
        return new HikariDataSource(config);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManager() {
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.driver", environment.getRequiredProperty("jdbc.driverClassName"));
        properties.put("javax.persistence.jdbc.url", environment.getRequiredProperty("jdbc.url"));
        properties.put("javax.persistence.jdbc.user", environment.getRequiredProperty("jdbc.username"));
        properties.put("javax.persistence.jdbc.password", environment.getRequiredProperty("jdbc.password"));
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.taran.navitex.entity");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(properties);
        return em;
    }

    @Bean
    public JpaTransactionManager getTransactionManager() {
        return new JpaTransactionManager(entityManager().getObject());
    }

}
