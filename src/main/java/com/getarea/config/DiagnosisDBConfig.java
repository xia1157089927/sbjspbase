package com.getarea.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.getarea.util.db.jdbc.SpringJdbcUntil;

@Configuration
@EnableTransactionManagement
public class DiagnosisDBConfig {

    @Autowired @Qualifier("getareaDataSource")
    private DataSource getareaDataSource;
    
    @Bean(name="jdbcTemplateGetarea")
    public JdbcTemplate jdbcTemplateGetarea(){
    	return new JdbcTemplate(getareaDataSource);
    }
    
    @Bean(name="dataSourceTransactionManagerGetarea")
    public DataSourceTransactionManager dataSourceTransactionManagerGetarea(){
    	return new DataSourceTransactionManager(getareaDataSource);
    }
    
    @Bean(name="transactionTemplateGetarea")
    public TransactionTemplate transactionTemplateGetarea() {
    	return new TransactionTemplate(dataSourceTransactionManagerGetarea());
    }
    
    @Bean(name="areaDbUtil")
    public SpringJdbcUntil springJdbcUtilGetarea(){
    	return new SpringJdbcUntil(getareaDataSource, transactionTemplateGetarea());
    }
    
}