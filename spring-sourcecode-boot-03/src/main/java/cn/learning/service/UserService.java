package cn.learning.service;

import cn.learning.properties.MyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Package: cn.learning.service
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/31 19:10
 */

@Component
public class UserService {

	/*
	方法0:直接在变量上使用 @Value 注解
	@Value("${password}")
	private String password;
	 */

	@Autowired
	private MyProperties myProperties;

	public void test() {
		System.out.println(myProperties.getPassword());
	}
}
