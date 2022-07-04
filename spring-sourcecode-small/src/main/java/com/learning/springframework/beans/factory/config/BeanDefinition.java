package com.learning.springframework.beans.factory.config;

/**
 * @Package: com.learning.springframework
 * @Description: BeanDefinition Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:48
 */

public class BeanDefinition {
	private Class beanClass;

	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
	}

	public Class getBeanClass() {
		return beanClass;
	}
}
