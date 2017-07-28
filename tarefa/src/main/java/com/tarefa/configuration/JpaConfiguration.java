package com.tarefa.configuration;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class JpaConfiguration {

	@Bean(initMethod = "migrate")
	public Flyway flywayInitData() {
		final Flyway flyway = new Flyway();
		flyway.setSchemas("SCHEMA_TAREFA");
		flyway.setLocations("classpath:db/migration");
		flyway.setBaselineOnMigrate(true);
		flyway.setTable("schema_data_versions");
		flyway.setDataSource(getDataSource());
		return flyway;
	}

	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSource getDataSource() {
		return DataSourceBuilder.create().build();
	}

}
