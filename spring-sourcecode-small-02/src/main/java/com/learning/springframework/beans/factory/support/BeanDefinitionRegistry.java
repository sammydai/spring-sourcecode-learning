package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: BeanDefinitionRegistry Test
 * @Author: Sammy
 * @Date: 2022/7/4 18:56
 */

public interface BeanDefinitionRegistry {

	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

}
