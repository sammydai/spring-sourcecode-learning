package com.learning;

import com.learning.service.AppConfig;
import com.learning.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Package: com.learning.service
 * @Description: Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:29
 */

public class MyApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		UserService userService = (UserService) context.getBean(UserService.class);

		userService.test();
	}
}
