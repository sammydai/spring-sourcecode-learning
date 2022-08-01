package cn.learning;


import cn.learning.service.OrderService;
import cn.learning.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SourceApplication {

	@Bean
	public UserService userService1() {
		return new UserService();
	}

    public static void main( String[] args ) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SourceApplication.class);
		System.out.println(applicationContext.getBean(OrderService.class));
	}

}
