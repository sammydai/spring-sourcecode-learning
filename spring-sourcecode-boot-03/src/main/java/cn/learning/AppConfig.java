package cn.learning;

import cn.learning.service.MemberService;
import cn.learning.service.OrderService;
import cn.learning.service.UserService;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: cn.learning.service
 * @Description: AppConfig
 * 场景：将配置文件里的值，映射给类中的变量，进行绑定
 * 方式一：使用 @EnableConfigurationProperties(MyProperties.class)
 * 开启自动绑定配置属性的功能，将配置文件中的内容绑定到MyProperties这个类
 * 属性绑定是一个动作，这个动作有启动条件，并不是任何情况都会发生
 * 一般会使用配置绑定的注解
 * 方式二：单独设置一个包放置所有的properties类，使用@ConfigurationPropertiesScan注解去扫描
 * @Author: Sammy
 * @Date: 2022/7/31 20:43
 */
@Configuration
//@EnableConfigurationProperties(MyProperties.class)
@ConfigurationPropertiesScan("cn.learning.properties")
public class AppConfig {

	@Bean
	// @ConditionalOnBean(value = MemberService.class)
	// @ConditionalOnBean(name = "userService")
	// @ConditionalOnMissingBean
	// @ConditionalOnSingleCandidate(value = UserService.class)
	// @ConditionalOnClass(value = UserService.class)
	// @ConditionalOnMissingClass(value = "cn.learning.service.UserService")
	// @ConditionalOnWebApplication //判断是不是一个web应用
	// @ConditionalOnProperty(prefix = "test",name = "condition123",havingValue = "true",matchIfMissing = true)
	// @ConditionalOnResource(resources = "http://www.baiduxxxxx.com")
	public OrderService orderService() {
		return new OrderService();
	}
}
