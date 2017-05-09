package com.getarea.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 数据库连接池
 * @author xiams
 * @version 1.0
 * @date 2017-05-08 10:59:38
 */
@Configuration
public class DataSourceConfig {

	@Primary
	@Bean(name = "getareaDataSource")
	@Qualifier("getareaDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.getarea.mysql")
	public DataSource getareaDataSource() throws SQLException {
		DataSource dataSource = DataSourceBuilder.create().build();
		dataSource.setLoginTimeout(600);
		return dataSource;
	}

}
