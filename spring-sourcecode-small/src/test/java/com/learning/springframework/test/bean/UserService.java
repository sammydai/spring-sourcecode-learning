package com.learning.springframework.test.bean;

/**
 * @Package: com.learning.springframework.test.bean
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/4 13:51
 */

public class UserService {

	private String name;

	public UserService(String name) {
		this.name = name;
	}

	public void queryUserInfo(){
        System.out.println("查询用户信息");
    }
}
