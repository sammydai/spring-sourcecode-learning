package com.learning.springframework;

import com.learning.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.learning.springframework
 * @Description: BeanFactory Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:49
 */

public class BeanFactory {
	private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	public Object getBean(String beanName) {
		return beanDefinitionMap.get(beanName).getBean();
	}

	public void registerBeanDefinition(String name,BeanDefinition beanDefinition) {
		beanDefinitionMap.put(name, beanDefinition);
	}
}
