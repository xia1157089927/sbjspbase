package com.getarea.util.db;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * springjdbc分页实现
 * @author xiams
 * @version 1.0
 * @date 2017-05-11 17:01:02
 */
public class Pagination extends JdbcDaoSupport{
	private static Logger LOG = LoggerFactory.getLogger(Pagination.class);
	//数据库类型
	private String dbType;
	
	//每页的条数
	public static final int NUMBERS_PER_PAGE = 15;
	// 一页显示的记录数
	private int numPerPage;
	// 记录总数
	private int totalRows;
	// 总页数
	private int totalPages;
	// 当前页码
	private int currentPage;
	// 起始行数
	private int startIndex;
	// 结束行数
	private int lastIndex;
	// 结果集存放List
	private List<Object> resultList;
	// JdbcTemplate jTemplate
	private JdbcTemplate jdbcTemplate;
	
	/**
	* 每页显示10条记录的构造函数,使用该函数必须先给Pagination设置currentPage，jTemplate初值
	* @param sql
	* oracle语句
	*/
	public Pagination() {
		
	}
	
	public Pagination(DataSource dataSource, JdbcTemplate jdbcTemplate, String dbType) {
		LOG.info("dbType:{}", dbType);
		this.setDataSource(dataSource);
		this.jdbcTemplate = jdbcTemplate;
		this.dbType = dbType; //数据库类型
		
	}
	
	public Pagination(String sql) {
		if (jdbcTemplate == null) {
		    throw new IllegalArgumentException( "com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
	    } else if (sql.equals("")) {
	    	throw new IllegalArgumentException("com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
	    }
	    new Pagination(sql, currentPage, NUMBERS_PER_PAGE, jdbcTemplate, null);
	}
	
	public Pagination(String sql, int currentPage, int numPerPage, JdbcTemplate jdbcTemplate, RowMapper<Object> rowMapper) {
		this.currentPage = currentPage;
	    
		if (jdbcTemplate == null){
		    throw new IllegalArgumentException("com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
	    } else if (sql == null || sql.equals("")) {
	    	throw new IllegalArgumentException("com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
	    }
	    // 设置每页显示记录数
	    setNumPerPage(numPerPage);
	    // 设置要显示的页数
		setCurrentPage(currentPage);
		LOG.info("Pagination currentPage="+currentPage);
		// 计算总记录数
		StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
		totalSQL.append(sql);
		totalSQL.append(" ) totalTable ");
		// 给JdbcTemplate赋值
		setJdbcTemplate(jdbcTemplate);
	    // 总记录数
		setTotalRows(getJdbcTemplate().queryForObject(totalSQL.toString(), Integer.class));
		// 计算总页数
		setTotalPages();
		// 计算起始行数
		setStartIndex();
		// 计算结束行数
		setLastIndex();
		LOG.info("lastIndex=" + lastIndex);// ////////////////
		// 构造oracle数据库的分页语句
		StringBuffer paginationSQL = null;
		
		if(dbType.equals("oracle")){
			paginationSQL = new StringBuffer(" SELECT * FROM ( ");
			paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
			paginationSQL.append(sql);
			paginationSQL.append("　) temp where ROWNUM <= " + lastIndex);
			paginationSQL.append(" ) WHERE　num > " + startIndex);
			LOG.info("sql:"+paginationSQL.toString());
		} else {
			
		}
		// 装入结果集
		setResultList(getJdbcTemplate().query(paginationSQL.toString(),rowMapper));
	}
	
	/**
	* @param args
	*/
	public int getCurrentPage() {
	   return currentPage;
	}

	public void setCurrentPage(int currentPage) {
	   this.currentPage = currentPage;
	}

	public int getNumPerPage() {
	   return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
	   this.numPerPage = numPerPage;
	}
	
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		if (dbType != null) {
			this.dbType = dbType;
		}
	}

	public int getTotalPages() {
	   return totalPages;
	}

	// 计算总页数
	public void setTotalPages() {
	   if(totalRows % numPerPage == 0){
		   this.totalPages = totalRows / numPerPage;
	   } else {
		   this.totalPages= (totalRows / numPerPage) + 1;
	   }
	}

	public int getTotalRows() {
	   return totalRows;
	}

	public void setTotalRows(int totalRows) {
	   this.totalRows = totalRows;
	}

	public int getStartIndex() {
	   return startIndex;
	}

	public void setStartIndex() {
	   this.startIndex = (currentPage - 1) * numPerPage;
	}

	public int getLastIndex() {
	   return lastIndex;
	}

	public JdbcTemplate getJTemplate() {
	   return jdbcTemplate;
	}

	public void setJTemplate(JdbcTemplate template) {
		jdbcTemplate = template;
	}

	// 计算结束时候的索引

	public void setLastIndex() {
		LOG.info("totalRows=" + totalRows); 
		LOG.info("numPerPage=" + numPerPage); 
		if (totalRows < numPerPage) {
			this.lastIndex = totalRows;
		} else if ((totalRows % numPerPage == 0) || (totalRows % numPerPage != 0 && currentPage < totalPages)) {
			this.lastIndex = currentPage * numPerPage;
		} else if (totalRows % numPerPage != 0 && currentPage == totalPages) {//最后一页
			this.lastIndex = totalRows;
		}
	}

	public List<Object> getResultList() {
	   return resultList;
	}

	public void setResultList(List<Object> resultList) {
	   this.resultList = resultList;
	}
	
}
