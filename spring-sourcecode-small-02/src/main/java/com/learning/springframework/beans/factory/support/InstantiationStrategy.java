package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: InstantiationStrategy Test
 * @Author: Sammy
 * @Date: 2022/7/4 21:05
 */

public interface InstantiationStrategy {
	/**
	 * 定义实例化策略接口
	 * @param beanDefinition
	 * @param beanName
	 * @param constructor 构造方法
	 * @param args 构造入参
	 * @return
	 */
	Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor constructor, Object[] args) throws BeansException;

}
