package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.BeansException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: BeanDefinitionReader class
 * @Author: Sammy
 * @Date: 2022/7/12 10:18
 */

public interface BeanDefinitionReader {

	BeanDefinitionRegistry getRegistry();

	ResourceLoader getResourceLoader();

	void loadBeanDefinitions(Resource resource) throws BeansException;

	void loadBeanDefinitions(Resource... resources) throws BeansException;

	void loadBeanDefinitions(String location) throws BeansException;
}
