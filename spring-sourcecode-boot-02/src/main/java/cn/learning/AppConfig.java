package cn.learning;

import cn.learning.service.MemberService;
import cn.learning.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Member;

/**
 * @Package: cn.learning
 * @Description: AppConfig
 * 1、告诉Spring这是一个配置类，扫描到这个类的时候，进一步扫描所有的bean
 * 2、告诉Spring这里面的方法，要不要进行代理，默认proxyBeanMethods = true，使用代理
 * 比如orderservice，orderservice1使用memberservice，使用的是同一个memberservice对象
 * 3、Configuration需要被Spring扫描到这个类
 *
 *
 * @Author: Sammy
 * @Date: 2022/7/31 19:35
 */
//@Configuration(proxyBeanMethods = false)
//@Configuration
//可以通过@Import方式，把单独的OrderService作为一个bean注入进来
//@Import(OrderService.class)
public class AppConfig {

	@Bean
	public OrderService orderService() {
		// System.out.println(memberService());
		return new OrderService();
	}

	// @Bean
	// public OrderService orderService1() {
	// 	System.out.println(memberService());
	// 	return new OrderService();
	// }

	@Bean
	public MemberService memberService() {
		return new MemberService();
	}
}
