package com.learning.springframework.beans;

/**
 * @Package: com.learning.springframework.beans
 * @Description: PropertyValue bean的属性
 * @Author: Sammy
 * @Date: 2022/7/5 09:31
 */

public class PropertyValue {
	private String name;
	private Object value;

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}
}
