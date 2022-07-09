package com.learning.springframework.beans.factory.config;

/**
 * @Package: com.learning.springframework.beans.factory.config
 * @Description: BeanReference Bean属性中的引用对象
 * @Author: Sammy
 * @Date: 2022/7/5 09:35
 */

public class BeanReference {

	private final String beanName;

	public BeanReference(String beanName) {
		this.beanName = beanName;
	}

	public String getBeanName() {
		return beanName;
	}
}
