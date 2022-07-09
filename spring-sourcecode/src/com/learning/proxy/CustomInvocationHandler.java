package com.learning.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Package: com.learning.proxy
 * @Description: CustomInvocationHandler
 * @Author: Sammy
 * @Date: 2022/7/9 22:32
 */

public class CustomInvocationHandler implements InvocationHandler {

	private Object target;

	public CustomInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("Proxy: 找代理对象帮我去购买房子......");
		Object ret = method.invoke(target, args);
		System.out.println("Proxy: 代理对象帮我把房子购买好了......");
		return ret;
	}
}
