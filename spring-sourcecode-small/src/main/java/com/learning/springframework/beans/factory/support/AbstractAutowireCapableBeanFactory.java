package com.learning.springframework.beans.factory.support;

import com.learning.springframework.beans.factory.BeansException;
import com.learning.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Package: com.learning.springframework.beans.factory.support
 * @Description: AbstractAutowireCapableBeanFactory Test
 * @Author: Sammy
 * @Date: 2022/7/4 18:15
 */

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}

	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}

	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;
		try {
			bean = createBeanInstance(beanName, beanDefinition, args);
		} catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
		addSingleton(beanName, bean);
		return bean;
	}

	protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getConstructors();
		for (Constructor<?> ctor : declaredConstructors) {
			if (null != args && ctor.getParameterTypes().length == args.length) {
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
	}

}
