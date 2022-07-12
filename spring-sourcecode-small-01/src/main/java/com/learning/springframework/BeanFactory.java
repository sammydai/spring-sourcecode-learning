package com.learning.springframework;

import com.learning.springframework.beans.factory.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.learning.springframework
 * @Description: BeanFactory Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:49
 */

public interface BeanFactory {

	Object getBean(String beanName) throws BeansException;

	/**
	 * 把构造函数的入参信息传递到实例化操作里
	 * @param beanName
	 * @param args
	 * @return
	 * @throws BeansException
	 */
	Object getBean(String beanName, Object... args) throws BeansException;

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
