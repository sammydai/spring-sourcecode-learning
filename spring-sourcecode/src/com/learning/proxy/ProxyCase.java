package com.learning.proxy;

/**
 * @Package: com.learning.proxy
 * @Description: Proxy
 * @Author: Sammy
 * @Date: 2022/7/9 22:16
 */

public class ProxyCase implements AbstractInterface{

	private Target target;

	public ProxyCase(Target target) {
		this.target = target;
	}

	@Override
	public void buyHouse() {
		System.out.println("Proxy: 找代理对象帮我去购买房子......");
		target.buyHouse();
		System.out.println("Proxy: 代理对象帮我把房子购买好了......");
	}
}
