package com.learning.proxy;

/**
 * @Package: com.learning.proxy
 * @Description: Test Proxy
 * @Author: Sammy
 * @Date: 2022/7/9 22:25
 */

public class TestProxy {
	public static void main(String[] args) {
		AbstractInterface target = new Target();
		AbstractInterface proxyInstance = (AbstractInterface) ProxyFactory.getProxyInstance(target);
		proxyInstance.buyHouse();
	}

	public void test() {
		Target target = new Target();
		ProxyCase proxy = new ProxyCase(target);
		proxy.buyHouse();
	}
}
