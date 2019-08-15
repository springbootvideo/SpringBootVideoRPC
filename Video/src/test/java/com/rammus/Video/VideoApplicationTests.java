package com.rammus.Video;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {

	@Test
	public void contextLoads() {
		String passwordString = "123456";
		String md = DigestUtils.md5DigestAsHex(passwordString.getBytes());
		System.out.println(md);
	}

}
