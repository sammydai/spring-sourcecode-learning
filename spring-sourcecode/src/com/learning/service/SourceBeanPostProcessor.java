package com.learning.service;

import com.learning.spring.BeanPostProcessor;
import com.learning.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Package: com.learning.service
 * @Description: SourceBeanPostProcessor 也把它看成一个component
 * @Author: Sammy
 * @Date: 2022/7/6 23:19
 */
@Component
public class SourceBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(String beanName, Object bean) {
		if (beanName.equals("userService")) {
           System.out.println("1111");
       }
       return bean;
	}

	@Override
	public Object postProcessAfterInitialization(String beanName, Object bean) {

		if (beanName.equals("userService")) {
			Object proxyInstance = Proxy.newProxyInstance(SourceBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("切面逻辑");
					return null;
				}
			});

			return proxyInstance;
		}
       return bean;

		// if (beanName.equals("userService")) {
        //     Object proxyInstance = Proxy.newProxyInstance(ZhouyuBeanPostProcessor.class.getClassLoader(), bean.getClass().getInterfaces(), new InvocationHandler() {
        //         @Override
        //         public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //             System.out.println("切面逻辑");
        //             return method.invoke(bean, args);
        //         }
        //     });
		//
        //     return proxyInstance;
        // }
		//
        // return bean;
	}
}
