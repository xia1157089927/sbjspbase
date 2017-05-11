package com.getarea.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import com.getarea.util.db.Pagination;
import com.getarea.util.db.jdbc.SpringJdbcUntil;

@Configuration
@EnableTransactionManagement
public class DiagnosisDBConfig {
	private static Logger LOG = LoggerFactory.getLogger(DiagnosisDBConfig.class);
	
	@Autowired
	private Environment env; 
	
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
    
    @Primary
    @Bean(name="springJdbcUtil_Getarea")
    public SpringJdbcUntil springJdbcUtilGetarea(){
    	return new SpringJdbcUntil(getareaDataSource, transactionTemplateGetarea());
    }
    
    /**
     * Getarea 数据库 分页插件初始化
     * @param jdbcTemplateGetarea
     * @return
     */
    @Bean(name="pagination_Getarea")
    public Pagination PaginationGetarea(){
    	String dbType = env.getProperty("App.dbType");
    	LOG.info("dbType:", dbType);
    	return new Pagination(getareaDataSource, jdbcTemplateGetarea(), dbType);
    }
}