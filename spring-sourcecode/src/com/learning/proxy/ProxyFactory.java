package com.learning.proxy;

import java.lang.reflect.Proxy;

/**
 * @Package: com.learning.proxy
 * @Description: ProxyFactory
 * @Author: Sammy
 * @Date: 2022/7/9 22:36
 */

public class ProxyFactory {

	public static Object getProxyInstance(Object target) {
		ClassLoader classLoader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		CustomInvocationHandler invocationHandler = new CustomInvocationHandler(target);
		return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
	}
}
