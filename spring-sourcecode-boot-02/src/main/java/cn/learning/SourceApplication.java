package cn.learning;


import cn.learning.service.OrderService;
import cn.learning.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(
		excludeFilters = {@ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {TypeExcludeFilter.class}
		), @ComponentScan.Filter(
				type = FilterType.CUSTOM,
				classes = {AutoConfigurationExcludeFilter.class}
		)}
)
public class SourceApplication {

    public static void main( String[] args ) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SourceApplication.class);
		System.out.println(applicationContext.getBean(UserService.class));
	}

	/**
	 * 可以自定义datasource
	 * 如果不定义，使用默认的HikariDataSource
	 * @return
	 */
	// @Bean
	// public DataSource dataSource() {
	// 	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	// 	return dataSource;
	// }

}
