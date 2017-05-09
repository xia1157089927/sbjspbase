package com.xia.reptile.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.getarea.Application;
import com.getarea.util.HttpsUtils;
import com.getarea.util.db.jdbc.BatchSql;
import com.getarea.util.db.jdbc.SpringJdbcUntil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@RunWith(SpringJUnit4ClassRunner.class)  
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类 
public class TestUserService {
	//https://www.taobao.com/home/js/sys/districtselector.js?t=20140318.js    JS入口
	
	private static Logger logger = LoggerFactory.getLogger(SpringJdbcUntil.class);
	
	@Autowired @Qualifier("areaDbUtil")
	private SpringJdbcUntil getareaDbUtil;  
	
	/*@Autowired
	private SpringJdbcUntil db;*/
	
	@Test
	public void batchInsert_Getarea(){
		BatchSql batchSql = new BatchSql();
		String sql = "insert into users(email, name) values(?, ?)";
		System.out.println(getareaDbUtil == null);
		for (int i = 0; i < 10; i++) {
			batchSql.addBatch(sql, new Object[]{i+"_1157089927@qq.com", "Xiams" + i});
		}
		getareaDbUtil.doInTransaction(batchSql);
	}
	
	/*@Test
	public void batchInsert_db(){
		BatchSql batchSql = new BatchSql();
		String sql = "insert into users(email, name) values(?, ?)";
		System.out.println(getareaDbUtil == null);
		for (int i = 0; i < 10; i++) {
			batchSql.addBatch(sql, new Object[]{i+"_1157089927@qq.com", "Xiams" + i});
		}
		db.doInTransaction(batchSql);
	}*/
	
	@Test
	public void testInsert(){
		String sql = "insert into users(email, name) values(?, ?)";
		getareaDbUtil.update(sql, new Object[]{"dbGetarea_1157089927@qq.com", "Xiams"});
	}
	
	/*@Test
	public void testInsert_Db(){
		String sql = "insert into users(email, name) values(?, ?)";
		db.update(sql, new Object[]{"db_1157089927@qq.com", "Xiams"});
	}*/
	
	@Test
	public void getRemoteData(){
		String sql_sheng = " select * from t_sheng_001 ";
		String sql_shi = " select * from t_shi_001 a where  a.pcode = ? ";
		String sql_qu = " select * from t_qu_001 a where  a.pcode = ? ";
		String insert_sql = "insert into t_detail_001(code, name, pcode, pingying) values(?, ?, ?, ?)";
		
		int shengCode = 0;
		int shiCode = 0;
		int quCode = 0;
		
		int count = 0;
		List<Map<String, Object>> shengList = getareaDbUtil.queryForList(sql_sheng, new Object[]{});
		for (Map<String, Object> shengMap : shengList) {
			shengCode = Integer.parseInt(shengMap.get("code").toString());
			
			List<Map<String, Object>> shiList = getareaDbUtil.queryForList(sql_shi, new Object[]{shengCode});
			for (Map<String, Object> shiMap : shiList) {
				shiCode = Integer.parseInt(shiMap.get("code").toString());
				
				List<Map<String, Object>> quList = getareaDbUtil.queryForList(sql_qu, new Object[]{shiCode});
				for (Map<String, Object> quMap : quList) {
					quCode = Integer.parseInt(quMap.get("code").toString());
					String urlStr = "https://lsp.wuliu.taobao.com/locationservice/addr/output_address_town_array.do?l1=shengCode&l2=shiCode&l3=quCode&lang=zh-S&_ksTS=1493967921570_7597&callback=jsonp7598";
					urlStr = urlStr.replaceAll("shengCode", shengCode+"").replaceAll("shiCode", shiCode+"").replaceAll("quCode", quCode+"");

					try {
						String resPstr = HttpsUtils.post(urlStr, new HashMap<>(), new HashMap<>(), null);
						String endStr = resPstr.substring(resPstr.indexOf("{"), resPstr.indexOf("}")+1);
						Gson gson = new Gson();
						JSONObject json = new JSONObject(endStr);

						List<List<String>> list = gson.fromJson(json.get("result").toString(), new TypeToken<List<List<String>>>() {
						}.getType());
						count++;
						logger.info("-------{}----start------", count);
						for (List<String> list2 : list) {
							logger.info("{},{},{},{}",list2.get(0), list2.get(1), list2.get(2), list2.get(3));
							getareaDbUtil.save(insert_sql, new Object[]{list2.get(0), list2.get(1), list2.get(2), list2.get(3)});
						}
						logger.info("-------{}----end------", count);
						logger.info("-------^^^^^^^^^------");
						logger.info("-------^^^^^^^^^------");
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
			
		}
		
	}
	
	
}
