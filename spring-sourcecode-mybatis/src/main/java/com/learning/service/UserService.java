package com.learning.service;

import com.learning.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package: com.learning.service
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/10 13:38
 */
@Component
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	public void test() {
		userMapper.insertOne();
		System.out.println(userMapper);
		// throw new NullPointerException();
	}
}
