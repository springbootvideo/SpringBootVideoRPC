package com.rammus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rammus.mapper")//扫该路径下的接口
public class VideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
	}

}
