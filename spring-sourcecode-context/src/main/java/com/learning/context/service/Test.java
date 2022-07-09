package com.learning.context.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Package: com.learning.service
 * @Description: Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:29
 */

public class Test {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService userService = (UserService) context.getBean("userService");
		userService.test();
		// System.out.println(context.getBean("orderService"));
		// System.out.println(context.getBean("orderService"));
		// System.out.println(context.getBean("orderService"));
		// System.out.println(context.getBean("orderService1"));
		// System.out.println(context.getBean("orderService2"));
	}
}
