package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: DefaultSingletonBeanRegistry Test
 * @Author: Sammy
 * @Date: 2022/7/4 18:29
 */

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

	private Map<String, Object> singletonObjects = new HashMap<>();

	@Override
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}

	protected void addSingleton(String beanName,Object singletonObject){
		singletonObjects.put(beanName, singletonObject);
	}
}
