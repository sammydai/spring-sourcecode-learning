package com.learning.service;

import com.learning.spring.SourceApplicationContext;

/**
 * @Package: com.learning.service
 * @Description: Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:29
 */

public class Test {
	public static void main(String[] args) {
		SourceApplicationContext context = new SourceApplicationContext(AppConfig.class);
		UserInterface userService = (UserInterface) context.getBean("userService");
		userService.test();
	}
}
