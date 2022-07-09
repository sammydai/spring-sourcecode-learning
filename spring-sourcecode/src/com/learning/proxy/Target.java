package com.learning.proxy;

/**
 * @Package: com.learning.proxy
 * @Description: Target
 * @Author: Sammy
 * @Date: 2022/7/9 22:16
 */

public class Target implements AbstractInterface {

	@Override
	public void buyHouse() {
		System.out.println("Target: 目标对象购买房子成功......");
	}
}
