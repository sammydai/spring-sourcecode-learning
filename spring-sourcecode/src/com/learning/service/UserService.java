package com.learning.service;

import com.learning.spring.Autowired;
import com.learning.spring.Component;
import com.learning.spring.Scope;

/**
 * @Package: com.learning.service
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/4 13:29
 */
@Component(value = "userService")
// @Scope(value = "prototype")
// @Scope(value = "singleton")
public class UserService {

	@Autowired
	private OrderService orderService;

	public void test() {
		System.out.println(orderService);
	}
}
