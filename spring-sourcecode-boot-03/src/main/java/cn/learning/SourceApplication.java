package cn.learning;


import cn.learning.service.OrderService;
import cn.learning.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource("application123.properties")
 * 可以通过这个注解，自己应用特定的配置文件
 */
@SpringBootApplication
public class SourceApplication {

	// @Bean
	// public UserService userService1() {
	// 	return new UserService();
	// }

    public static void main( String[] args ) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SourceApplication.class);
		UserService bean = applicationContext.getBean(UserService.class);
		bean.test();
	}

}
