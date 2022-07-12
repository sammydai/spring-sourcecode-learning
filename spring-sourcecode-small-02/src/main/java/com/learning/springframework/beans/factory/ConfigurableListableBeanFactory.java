package com.learning.springframework.beans.factory;

import com.learning.springframework.beans.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

/**
 * @Package: com.learning.springframework.beans.factory
 * @Description: ConfigurableListableBeanFactory
 * 提供分析和修改Bean以及预先实例化的操作接口
 * @Author: Sammy
 * @Date: 2022/7/12 10:50
 */

public interface ConfigurableListableBeanFactory {

	BeanDefinition getBeanDefinition(String beanName) throws BeansException;

}
