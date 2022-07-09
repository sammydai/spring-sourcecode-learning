package com.learning.context.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Package: com.learning.context.aspect
 * @Description: SourceAspect Test
 * @Author: Sammy
 * @Date: 2022/7/9 16:16
 * 如果一个Bean有aop代理对象，则把<br>代理对象</br>放到最后的Map<BeanName,Object>中
 */
@Component
@Aspect
public class SourceAspect {

	@Before("execution(public void com.learning.context.service.UserService.test())")
	public void sourceBefore(JoinPoint joinPoint) {
		System.out.println("sourceBefore");
	}
}

