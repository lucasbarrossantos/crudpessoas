package com.crudpessoas.core.heroku;

import com.zaxxer.hikari.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import javax.sql.DataSource;

@Getter
@Setter
@Configuration
@ConfigurationProperties("spring.datasource")
public class DatabaseConfig {

    private String url;
    private String username;
    private String password;

    @Profile("dev")
    @Bean
    public DataSource dataSourceDev() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        return new HikariDataSource(config);
    }

    @Profile("prod")
    @Bean
    public DataSource dataSourceProd() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        return new HikariDataSource(config);
    }

}
