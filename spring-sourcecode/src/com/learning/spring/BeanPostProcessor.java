package com.learning.spring;

/**
 * @Package: com.learning.spring
 * @Description: BeanPostProcessor Test
 * @Author: Sammy
 * @Date: 2022/7/6 23:17
 */

public interface BeanPostProcessor {

	public Object postProcessBeforeInitialization(String beanName,Object bean);

	public Object postProcessAfterInitialization(String beanName,Object bean);

}
