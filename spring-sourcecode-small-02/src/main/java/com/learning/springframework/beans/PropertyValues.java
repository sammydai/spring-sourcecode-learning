package com.learning.springframework.beans;

import org.w3c.dom.stylesheets.LinkStyle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package: com.learning.springframework.beans.factory
 * @Description: PropertyValues bean的属性定义
 * @Author: Sammy
 * @Date: 2022/7/5 09:30
 */

public class PropertyValues {

	private final List<PropertyValue> propertyValueList = new ArrayList<>();

	public void addPropertyValue(PropertyValue pv) {
		this.propertyValueList.add(pv);
	}

	public PropertyValue[] getPropertyValues() {
		return this.propertyValueList.toArray(new PropertyValue[0]);
	}
}
