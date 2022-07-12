package com.learning.springframework;

import com.learning.springframework.beans.BeansException;

/**
 * @Package: com.learning.springframework
 * @Description: BeanFactory Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:49
 */

public interface BeanFactory {

	Object getBean(String beanName) throws BeansException;

	Object getBean(String beanName, Object... args) throws BeansException;

	<T> T getBean(String beanName, Class<T> requiredType);

	// private Map<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
	//
	// public Object getBean(String beanName) {
	// 	return beanDefinitionMap.get(beanName).getBean();
	// }
	//
	// public void registerBeanDefinition(String name,BeanDefinition beanDefinition) {
	// 	beanDefinitionMap.put(name, beanDefinition);
	// }
}
