package cn.learning.service;

import cn.learning.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package: cn.learning.service
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/31 19:10
 */

@Component
public class UserService {

	@Autowired
	private UserMapper userMapper;

	@Transactional
	public void test() {
		userMapper.insertOne();
	}
}
