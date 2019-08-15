package com.rammus.config;

import java.util.Properties;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;


import com.github.pagehelper.PageHelper;

@SpringBootConfiguration
public class PageHelperConfig {

	@Bean
	public PageHelper pageHelper() {
		PageHelper helper = new PageHelper();
		Properties properties = new Properties();
	    properties.setProperty("offsetAspageNum", "true");
	    properties.setProperty("rowBoundsWithCount", "true");
	    properties.setProperty("reasonable", "true");
	    properties.setProperty("dialect","mysql");
	    helper.setProperties(properties);

		return helper;
	}
} 
