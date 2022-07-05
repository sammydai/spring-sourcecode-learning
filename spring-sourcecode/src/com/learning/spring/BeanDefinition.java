package com.learning.spring;

/**
 * @Package: com.learning.spring
 * @Description: BeanDefinition Test
 * @Author: Sammy
 * @Date: 2022/7/5 23:58
 */

public class BeanDefinition {

	private Class type;

	private String scope;

	public Class getType() {
		return type;
	}

	public void setType(Class type) {
		this.type = type;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
