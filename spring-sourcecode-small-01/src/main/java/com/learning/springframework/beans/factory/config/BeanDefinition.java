package com.learning.springframework.beans.factory.config;

import com.learning.springframework.beans.PropertyValues;

/**
 * @Package: com.learning.springframework
 * @Description: BeanDefinition Test
 * @Author: Sammy
 * @Date: 2022/7/4 13:48
 */

public class BeanDefinition {
	private Class beanClass;

	//bean的属性定义
	private PropertyValues propertyValues;

	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
		this.propertyValues = new PropertyValues();
	}

	public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
		this.beanClass = beanClass;
		this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
	}

	public Class getBeanClass() {
		return beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public void setPropertyValues(PropertyValues propertyValues) {
		this.propertyValues = propertyValues;
	}
}
