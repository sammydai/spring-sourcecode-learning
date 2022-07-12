package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: SimpleInstantiationStrategy
 * JDK 实例化
 * @Author: Sammy
 * @Date: 2022/7/4 21:31
 */

public class SimpleInstantiationStrategy implements InstantiationStrategy {

	@Override
	public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException {
		Class clazz = beanDefinition.getBeanClass();
		try {
			if (null != constructor) {
				return clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
			} else {
				return clazz.getDeclaredConstructor().newInstance();
			}
		}catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
			throw new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
	}
}
