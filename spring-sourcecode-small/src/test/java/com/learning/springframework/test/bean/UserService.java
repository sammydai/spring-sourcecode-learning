package com.learning.springframework.test.bean;

/**
 * @Package: com.learning.springframework.test.bean
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/4 13:51
 */

public class UserService {

	private String name;

	// public UserService() {
	// }

	/**
	 * 流程中哪里把构造函数的入参信息传递到实例化中
	 * 怎么去实例化含有构造函数的对象
	 * @param name
	 */
	public UserService(String name) {
		this.name = name;
	}

	public void queryUserInfo(){
		System.out.println("查询用户信息: " + name);
    }

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("");
		sb.append("").append(name);
		return sb.toString();
	}
}
