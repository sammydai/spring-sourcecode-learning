package com.learning.springframework.beans.factory.support;

import com.learning.springframework.BeanFactory;
import com.learning.springframework.beans.factory.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: AbstractBeanFactory Test
 * 抽象类定义模板方法(AbstractBeanFactory)
 * @Author: Sammy
 * @Date: 2022/7/4 14:06
 */

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

	/**
	 * 1、从单例Bean中获取beanName
	 * 2、如果存在返回，如果不存在，获取beandefinition
	 * 3、创建该bean
	 * @param beanName
	 * @return
	 */
	@Override
	public Object getBean(String beanName) throws BeansException {
		Object bean = getSingleton(beanName);
		if (bean != null) {
			return bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(beanName);
		return createBean(beanName, beanDefinition);

	}

	protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

	protected abstract Object createBean(String beanName,BeanDefinition beanDefinition	) throws BeansException;
}
