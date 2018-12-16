package com.orion.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
public class WebConfig {
	@Bean(name="db1")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource1")
	public DataSource db1()
	{
		return DataSourceBuilder.create().build();
	}
	@Bean(name="jdbcTemplate1")
	public JdbcTemplate jdbcTemplate1(@Qualifier("db1") DataSource ds)
	{
		return new JdbcTemplate(ds);
	}
	
	@Bean(name="db2")
	@ConfigurationProperties(prefix="spring.datasource2")
	public DataSource db2()
	{
		return DataSourceBuilder.create().build();
	}		
	@Bean(name="jdbcTemplate2")
	public JdbcTemplate jdbcTemplate2(@Qualifier("db2") DataSource ds)
	{
		return new JdbcTemplate(ds);
	}
	
}
