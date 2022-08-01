package cn.learning;

import cn.learning.service.MemberService;
import cn.learning.service.OrderService;
import cn.learning.service.UserService;
import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package: cn.learning.service
 * @Description: AppConfig
 * @Author: Sammy
 * @Date: 2022/7/31 20:43
 */
@Configuration
public class AppConfig {

	@Bean
	// @ConditionalOnBean(value = MemberService.class)
	// @ConditionalOnBean(name = "userService")
	// @ConditionalOnMissingBean
	// @ConditionalOnSingleCandidate(value = UserService.class)
	@ConditionalOnMissingClass(value = "cn.learning.service.UserService")
	public OrderService orderService() {
		return new OrderService();
	}
}
