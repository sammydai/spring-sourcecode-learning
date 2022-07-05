package com.learning.springframework.test;

import com.learning.springframework.beans.factory.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;
import com.learning.springframework.BeanFactory;
import com.learning.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.learning.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * @Package: com.learning.springframework.test
 * @Description: ApiTest
 * @Author: Sammy
 * @Date: 2022/7/4 13:50
 */

public class ApiTest {

	@Test
	public void test_BeanFactory() throws BeansException {
		// //1.生成工厂
		// BeanFactory beanFactory = new BeanFactory();
		// //2.注册bean
		// BeanDefinition beanDefinition = new BeanDefinition(new UserService());
		// beanFactory.registerBeanDefinition("userService",beanDefinition);
		// //3.获取bean
		// UserService userService = (UserService) beanFactory.getBean("userService");
		// userService.queryUserInfo();

		//1.生成工厂
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//2.注册bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		beanFactory.registerBeanDefinition("userService",beanDefinition);
		//3.第一次获取bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
		System.out.println("===userService:"+userService);
		//4.第二次获取 bean from Singleton
		UserService userService_singleton = (UserService) beanFactory.getBean("userService");
		userService_singleton.queryUserInfo();
		System.out.println("===userService_singleton:"+userService_singleton);
	}

	@Test
	public void test_BeanFactory2() throws BeansException {
		//1、创建工厂
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		//2、
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		//3、
		UserService userService = (UserService) beanFactory.getBean("userService", "晓明哥");
		userService.queryUserInfo();
	}

}
