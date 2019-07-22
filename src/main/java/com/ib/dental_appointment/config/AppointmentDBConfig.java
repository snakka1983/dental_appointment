/**
 * 
 */
package com.ib.dental_appointment.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author snakka
 *
 */
public class AppointmentDBConfig {

	@Value("${spring.datasource.driver-class-name}") 
    private String driverClassName;

    @Value("${spring.datasource.url}") 
    private String url;

    @Value("${spring.datasource.username}") 
    private String username;

    @Value("${spring.datasource.password}") 
    private String password;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
        return dataSource;
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	return new JdbcTemplate(dataSource);
    }
}
