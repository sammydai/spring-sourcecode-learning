package com.learning.springframework.test;

import com.learning.springframework.beans.factory.config.BeanDefinition;
import com.learning.springframework.BeanFactory;
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
	public void test_BeanFactory(){
		//1.生成工厂
		BeanFactory beanFactory = new BeanFactory();
		//2.注册bean
		BeanDefinition beanDefinition = new BeanDefinition(new UserService());
		beanFactory.registerBeanDefinition("userService",beanDefinition);
		//3.获取bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}

}
