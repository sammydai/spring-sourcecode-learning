package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: AbstractAutowireCapableBeanFactory Test
 * @Author: Sammy
 * @Date: 2022/7/4 18:15
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
		Object bean = null;
		try {
			 bean = beanDefinition.getBeanClass().newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
		addSingleton(beanName, bean);
		return bean;
	}
}
