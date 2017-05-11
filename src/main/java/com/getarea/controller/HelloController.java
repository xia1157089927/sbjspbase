package com.getarea.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
    // 从 application.properties 中读取配置，如取不到默认值为HelloShanhy
	@Value("${spring.application.name:Hello Angel}")
    private String hello;
	
	@RequestMapping("/helloJsp")
	public String helloJsp(Map<String,Object> map){
	    System.out.println("HelloController.helloJsp().hello=" + hello);
	    map.put("hello", hello);
	    return"helloJsp";
	}
	
	/**
	 * 跳转到bootstrap页面
	 * @param map
	 * @return
	 */
	@RequestMapping("/bootstrap")
	public String bootstrap(Map<String,Object> map){
		return "bootstrap";
	}
	
	/**
	 * 跳转到amazingUi主页
	 * @param map
	 * @return
	 */
	@RequestMapping("/adminTable")
	public String adminTable(Map<String,Object> map){
		return "admin-table";
	}
	
}
